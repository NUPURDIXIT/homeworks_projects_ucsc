/**
 * Created by nupur on 6/22/2016.
 */
function calculate() {
    
    //clear the values of the input fields
    document.getElementById("errors1").innerHTML="";
    document.getElementById("errors2").innerHTML="";
    document.getElementById("errors3").innerHTML="";
    document.getElementById("errors4").innerHTML="";
    document.getElementById("sponsors").innerHTML="";

    //retrieve the values from document
    var loanAmount = document.getElementById("LA").value;
    var AnnualInterest = document.getElementById("AI").value;
    var rePayYears = document.getElementById("RPY").value;
    var zipcode=document.getElementById("zip").value;
    
    
    //if the data entered is not valid then return
    if(!isValidInput(loanAmount, AnnualInterest, rePayYears,zipcode)){
        return;
    } 

    //Calculate the repay years in month 
    var rePayYearsInMonths = rePayYears * 12;

    //Calculate the Annual Interest per month (rate/12*100)
    var AnnIntPerMonth = AnnualInterest / 1200;

    //Calculate the monthly payment
    var monthlyPayment = loanAmount * AnnIntPerMonth / (1 - (Math.pow(1 / (1 + AnnIntPerMonth), rePayYearsInMonths)));


    //If the monthly payment is finite then perform other calculations
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

    //If the zipcode has been entered then retrieve the sponsors for loan
    if(zipcode!=''){
        getLenders(loanAmount,AnnualInterest,rePayYears,zipcode)
    }
    

}

//Method to ensure valid data has been input , else throw an error
function isValidInput(loanAmount, AnnualInterest, rePayYears,zipcode){
    var valid = true;

    //if the loan amount is either blank or negative then throw an error
    if(loanAmount=='' || loanAmount<0){
        document.getElementById("errors1").innerHTML="Please enter a valid loan amount";
        valid = false;
        
    }
    
     //if the annual interest is either blank or negative then throw an error
    if(AnnualInterest=='' || AnnualInterest<0){
        document.getElementById("errors2").innerHTML="Please enter a valid Annual Interest";
        valid = false;
    }

     //if the repay years is either blank or negative then throw an error
    if(rePayYears=='' || rePayYears<0){
        document.getElementById("errors3").innerHTML="Please enter valid Years";
        valid = false;
    }

    //Check for zipcode to have only digits using regular expression
    var numbers=/^[0-9]+$/;
    if(zipcode!=''){
        if(zipcode <0 || !zipcode.match(numbers)){
            document.getElementById("errors4").innerHTML="Please enter valid Zipcode";
            valid = false;
         }
    }

    return valid;
}



    
/******AJAX CALL to get the sponsors by retrieving data from php file**********************/
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
            for (var item in items) {
                output += "<a href='"+items[item]+"'>"+items[item]+ "</a><br>";
            }
        }

            document.getElementById('sponsors').innerHTML=output
        }

    req.open('GET','http://localhost/JSFinal/loan.php/',true);
    req.send();
}
    