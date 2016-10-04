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
    chart();

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

        save(loanAmount,AnnualInterest,rePayYears,zipcode);
        chart(loanAmount,AnnIntPerMonth,monthlyPayment,rePayYearsInMonths)
    }

    //If the zipcode has been entered then retrieve the sponsors for loan
    if(zipcode!=''){
        getLenders(loanAmount,AnnualInterest,rePayYears,zipcode)
    }
    

}

//Method to ensure valid data has been input on click of calculate button , else throw an error 
 function isValidInput(loanAmount, AnnualInterest, rePayYears,zipcode){
     var valid = true;
 
     if(!isValidLoanAmount(loanAmount)){
        valid = false;
     }

     if(!isValidAnnualInterest(AnnualInterest)){
        valid = false;
     }
     if(!isValidRePayYears(rePayYears)){
        valid = false;
     }
     if(!isValidZipcode(zipcode)){
        valid = false;
     }

     return valid;
 }

//function to save the values
function save(amount,apr,years,zipcode){
    if(window.localStorage){
        localStorage.loanAmount=amount;
        localStorage.AnnualInterest=apr;
        localStorage.rePayYears=years;
        localStorage.zipcode=zipcode;
    }
}

//Function to display graph showing monthly loan balance, equity and interest
function chart(loanAmount,AnnIntPerMonth,monthlyPayment,rePayYearsInMonths) {
    var graph = document.getElementById("graph"); // Get the <canvas> tag
    graph.width = graph.width; // This is to clear and reset the canvas element
    // If we're called with no arguments, or if this browser does not support
    // graphics in a <canvas> element, then just return now.
    if (arguments.length === 0 || !graph.getContext) return;
    // Get the "context" object for the canvas
    var g = graph.getContext("2d"); // All drawing is done with this object
    var width = graph.width,  
        height = graph.height; // Get canvas size
    // These functions convert payment numbers and dollar amounts to pixels
    function paymentToX(n) {
        return n * width / rePayYearsInMonths;
    }

    function amountToY(a) {
        return height - (a * height / (monthlyPayment * rePayYearsInMonths * 1.05));
    }
    // Payments are a straight line from (0,0) to (payments, monthly*payments)
    g.moveTo(paymentToX(0), amountToY(0)); // Start at lower left
    g.lineTo(paymentToX(rePayYearsInMonths), // Draw to upper right
    amountToY(monthlyPayment * rePayYearsInMonths));
    g.lineTo(paymentToX(rePayYearsInMonths), amountToY(0)); // Down to lower right
    g.closePath(); // And back to start
    g.fillStyle = "#f88"; // Light red
    g.fill(); // Fill the triangle
    g.font = "bold 12px sans-serif"; // Define a font
    g.fillText("Total Interest Payments", 20, 20); // Draw text in legend
   
    var equity = 0;
    g.beginPath(); // Begin a new shape
    g.moveTo(paymentToX(0), amountToY(0)); // starting at lower-left
    for (var p = 1; p <= rePayYearsInMonths; p++) {
        // For each payment, figure out how much is interest
        var thisMonthsInterest = (loanAmount - equity) * AnnIntPerMonth;
        equity += (monthlyPayment - thisMonthsInterest); // The rest goes to equity
        g.lineTo(paymentToX(p), amountToY(equity)); // Line to this point
    }
    g.lineTo(paymentToX(rePayYearsInMonths), amountToY(0)); // Line back to X axis
    g.closePath(); // And back to start point
    g.fillStyle = "orange"; // Now use orange paint
    g.fill(); // And fill area under curve
    g.fillText("Total Equity", 20, 35); // Label it in green
    // Loop again, as above, but chart loan balance as a thick black line
    var bal = loanAmount;
    g.beginPath();
    g.moveTo(paymentToX(0), amountToY(bal));
    for (var p = 1; p <= rePayYearsInMonths; p++) {
        var thisMonthsInterest = bal * AnnIntPerMonth;
        bal -= (monthlyPayment - thisMonthsInterest); // The rest goes to equity
        g.lineTo(paymentToX(p), amountToY(bal)); // Draw line to this point
    }
    g.lineWidth = 3; // Use a thick line
    g.stroke(); // Draw the balance curve
    g.fillStyle = "black"; // Switch to black text
    g.fillText("Loan Balance", 20, 50); // Legend entry
    // Now make yearly tick marks and year numbers on X axis
    g.textAlign = "center"; // Center text over ticks
    var y = amountToY(0); // Y coordinate of X axis
    for (var year = 1; year * 12 <= rePayYearsInMonths; year++) { // For each year
        var x = paymentToX(year * 12); // Compute tick position
        g.fillRect(x - 0.5, y - 3, 1, 3); // Draw the tick
        if (year == 1) g.fillText("Year", x, y - 5); // Label the axis
        if (year % 5 === 0 && year * 12 !== rePayYearsInMonths) // Number every 5 years
        g.fillText(String(year), x, y - 5);
    }
    // Mark payment amounts along the right edge
    g.textAlign = "right"; // Right-justify text
    g.textBaseline = "middle"; // Center it vertically
    var ticks = [monthlyPayment * rePayYearsInMonths, loanAmount]; // The two points which would be marked
    var rightEdge = paymentToX(rePayYearsInMonths); // X coordinate of Y axis
    for (var i = 0; i < ticks.length; i++) { // For each of the 2 points
        var y = amountToY(ticks[i]); // Compute Y position of tick
        g.fillRect(rightEdge - 3, y - 0.5, 3, 1); // Draw the tick mark
        g.fillText(String(parseFloat(ticks[i]).toFixed(0)), // And label it.
        rightEdge - 5, y);
    }
}

//Method to ensure valid data has been input for loan amount, else throw an error
function isValidLoanAmount(loanAmount){
    document.getElementById("errors1").innerHTML="";

    var valid = true;

    //if the loan amount is either blank or negative then throw an error
    if(loanAmount=='' || loanAmount<0){
        document.getElementById("errors1").innerHTML="Please enter a valid loan amount";
        valid = false;
        
    }
     return valid;
}


//Method to ensure valid data has been input for Annual Interest, else throw an error
function isValidAnnualInterest(AnnualInterest){
    document.getElementById("errors2").innerHTML="";

    var valid = true;
    
     //if the annual interest is either blank or negative then throw an error
    if(AnnualInterest=='' || AnnualInterest<0){
        document.getElementById("errors2").innerHTML="Please enter a valid Annual Interest";
        valid = false;
    }
     return valid;
}

//Method to ensure valid data has been input for repay years, else throw an error
function isValidRePayYears(rePayYears){
    document.getElementById("errors3").innerHTML="";

    var valid = true;
    
     //if the repay years is either blank or negative then throw an error
    if(rePayYears=='' || rePayYears<0){
        document.getElementById("errors3").innerHTML="Please enter valid Years";
        valid = false;
    }
     return valid;
}

//Check for zipcode to have only digits using regular expression else throw an error
function isValidZipcode(zipcode){
    document.getElementById("errors4").innerHTML="";

    var valid = true;
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

    req.open('GET','/loan.php',true);
    req.send();
}
    