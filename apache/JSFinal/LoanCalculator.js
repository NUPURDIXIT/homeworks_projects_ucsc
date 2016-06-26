/**
 * Created by nupur on 6/22/2016.
 */
function calculate() {
    
    document.getElementById("errors1").innerHTML="";
    document.getElementById("errors2").innerHTML="";
    document.getElementById("errors3").innerHTML="";
    document.getElementById("errors4").innerHTML="";
    document.getElementById("sponsors").innerHTML="";

    var loanAmount = document.getElementById("LA").value;
    var AnnualInterest = document.getElementById("AI").value;
    var rePayYears = document.getElementById("RPY").value;
    var zipcode=document.getElementById("zip").value;
    console.log("loan amount is:"+loanAmount)

    
    if(!isValidInput(loanAmount, AnnualInterest, rePayYears,zipcode)){
        return;
    } 

    var rePayYearsInMonths = rePayYears * 12;
    var AnnIntPerMonth = AnnualInterest / 1200;

    
    var monthlyPayment = loanAmount * AnnIntPerMonth / (1 - (Math.pow(1 / (1 + AnnIntPerMonth), rePayYearsInMonths)));


    if(isFinite(monthlyPayment)){
        monthlyPayment = monthlyPayment.toFixed(2);
        output1 = '$' + monthlyPayment
        document.getElementById('output1').innerHTML = output1;

        var totalPayment = monthlyPayment*rePayYearsInMonths;
        totalPayment = totalPayment.toFixed(2);
        output2 = '$' + totalPayment
        document.getElementById('output2').innerHTML = output2;

        var totalInterest = (rePayYearsInMonths * monthlyPayment) - loanAmount;
        totalInterest = totalInterest.toFixed(2);
        output3 = '$' + totalInterest
        document.getElementById('output3').innerHTML = output3;
    }

    console.log("zipcode is"+zipcode)
    if(zipcode!=''){

        getLenders(loanAmount,AnnualInterest,rePayYears,zipcode)
    }
    

}

function isValidInput(loanAmount, AnnualInterest, rePayYears,zipcode){
    var valid = true;
    if(loanAmount=='' || loanAmount<0){
        document.getElementById("errors1").innerHTML="Please enter a valid loan amount";
        valid = false;
        
    }
    
    if(AnnualInterest=='' || AnnualInterest<0){
        document.getElementById("errors2").innerHTML="Please enter a valid Annual Interest";
        valid = false;
    }

    if(rePayYears=='' || rePayYears<0){
        document.getElementById("errors3").innerHTML="Please enter valid Years";
        valid = false;
    }
    if(zipcode<0 || (!isNaN(parseInt(zipcode)))){
        document.getElementById("errors4").innerHTML="Please enter valid Zipcode";
        valid = false;
     }

    

    

    return valid;
}



    
/******AJAX CALL**********************/
function getRequest(){
    var request=new XMLHttpRequest();
    return request;
}

function getLenders(loanAmount,AnnualInterest,rePayYears,zipcode){
    var req=getRequest();
    var output=''
    req.onreadystatechange=function() {
        if (req.readyState == 4 && req.status == 200) {
            var items = JSON.parse(req.responseText)
            console.log(req.responseText);
            console.log(items);
            for (var item in items) {
                output += "<a href='"+items[item]+"'>"+items[item]+ "</a><br>";
            }
        }

            document.getElementById('sponsors').innerHTML=output
        }

    req.open('GET','http://localhost/JSFinal/loan.php/',true);
    req.send();
}
    