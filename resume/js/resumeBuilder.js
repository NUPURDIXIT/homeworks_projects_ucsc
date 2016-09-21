/*
This is empty on purpose! Your code to build the resume will go here.
*/
// var awesomeThoughts;
// var funThoughts;
// awesomeThoughts="My name is Nupur and I am awesome";
// //console.log(awesomeThoughts);
// funThoughts=awesomeThoughts.replace("awesome","fun");
// //$("#main").append(funThoughts);
// var formattedName=HTMLheaderName.replace("%data%","Nupur Dixit");
// var formattedRole=HTMLheaderRole.replace("%data%","Web Developer");
// $("#header").append(formattedName).append(formattedRole);


//BIO object
 var bio={
 	"name":"Nupur Dixit",
 	"role":"Software Developer",
 	"contact":{
 		"mobile":"632-456-7891",
 		"email":"nupurdixit13@gmail.com",
 		"github":"nupurdixit13",
 		"location":"San Mateo"
 	},
 	"skills":[
 				"java","python","machine learning","javascript"],
 	"pic":"./linkedIn_profileImg.jpg",
 	"welcome_message":"Hey! Good Evening?"
 }

 //work object
var work={
			"jobs":[
			{
		 		"Last_job_position":"Senior Software Engineer",
		 		"employer":"UHG",
		 		"Years_worked":"3.5years",
		 		"City":"Gurgaon",
		 		"Description":"I was in Development team worked for Customer and Liquidity Managament"
		 					
		 	},
		 	{
		 		"Last_job_position":"Software Engineer",
		 		"employer":"Infosys",
		 		"Years_worked":"2.5years",
		 		"City":"Pune",
		 		"Description":"I was in Solution Support and Operations team majorly responsible"+
		 						"for solving tickets and doing minor enhancements"
		 	}
		 	]
		 }
	
 //education object
 var education={};
 		education["Current_School"]="UCSC Extension";
 		education["Date_of_start"]="April 1 2016";
 		education["Schools_city"]="Santa Clara";
 		education["Degree"]="Professional Certification";


 $("#education").append(HTMLschoolStart);

 var formattedSchoolName=HTMLschoolName.replace("%data%",education.Current_School);
 var formattedDateOfStart=HTMLschoolDates.replace("%data%",education.Date_of_start);
 var formattedDegree=HTMLschoolDegree.replace("%data%",education.Degree)
 var formattedSchoolCity=HTMLschoolLocation.replace("%data%",education.Schools_city);
 $(".education-entry:last").append(formattedSchoolName);
 $(".education-entry:last").append(formattedDateOfStart);
 $(".education-entry:last").append(formattedDegree);
 $(".education-entry:last").append(formattedSchoolCity);



 //project object

 var project={
 	"projects":[{
	 		"titles":"Visitor log",
	 		"Dates":"April - May 2016",
	 		"Description": "Visitor log to record the details of the person visiting"
	 		},
	 		{
	 		"titles":"Bank Account",
	 		"Dates":"July-Aug 2016",
	 		"Description" : "Maintains a BankAccount in which the transaction can be performed"
 			}
 			]
 	};
 
 //project.display=function(){
 function displayProjects(){
 	for(i in project.projects){
 		$("#projects").append(HTMLprojectStart);

 		var formattedTitle=HTMLprojectTitle.replace("%data%",project.projects[i].titles);
		$(".project-entry:last").append(formattedTitle);

 		var formattedDates=HTMLprojectDates.replace("%data%",project.projects[i].Dates);
 		$(".project-entry:last").append(formattedDates);

 		var formattedDescription=HTMLprojectDescription.replace("%data%",project.projects[i].Description);
 		$(".project-entry:last").append(formattedDescription);

 	}
 }

displayProjects();

 var bioname=HTMLheaderName.replace("%data%",bio.name);
 var biorole=HTMLheaderRole.replace("%data%",bio.role);
 var biomobile=HTMLmobile.replace("%data%",bio.contact.mobile);
 var bioemail=HTMLemail.replace("%data%",bio.contact.email);
 var biogithub=HTMLgithub.replace("%data%",bio.contact.github);
 var biolocation=HTMLlocation.replace("%data%",bio.contact.location);
 var biopic=HTMLbioPic.replace("%data%",bio.pic);

 $("#header").append(bioname);
 $("#header").append(biorole);
 $("#header").append(biomobile);
 $("#header").append(bioemail);
 $("#header").append(biogithub);
 $("#header").append(biolocation);
 $("#header").append(biopic);
 

 if(bio.skills.length > 0){
  console.log("length is"+bio.skills.length);
  $("#header").append(HTMLskillsStart);
 }

var formattedSkill=HTMLskills.replace("%data%",bio.skills[0]);
 $("#skills").append(formattedSkill);
 formattedSkill=HTMLskills.replace("%data%",bio.skills[1]);
 
 $("#skills").append(formattedSkill);
 formattedSkill=HTMLskills.replace("%data%",bio.skills[2]);
 $("#skills").append(formattedSkill);
 formattedSkill=HTMLskills.replace("%data%",bio.skills[3]);
 $("#skills").append(formattedSkill);
 

function displayWork(){
	for(job in work.jobs){
		$("#workExperience").append(HTMLworkStart);
		var formattedEmployer=HTMLworkEmployer.replace("%data%",work.jobs[job].employer);
		var formattedPosition=HTMLworkTitle.replace("%data%",work.jobs[job].Last_job_position);
		var formattedTitle=formattedEmployer+formattedPosition;

		var formattedDate = HTMLworkDates.replace("%data%",work.jobs[job].Years_worked);
		var formattedLocation=HTMLworkLocation.replace("%data%",work.jobs[job].City);
		var formattedDescription=HTMLworkDescription.replace("%data%",work.jobs[job].Description);


		
		$(".work-entry:last").append(formattedDate);
		$(".work-entry:last").append(formattedLocation);
		$(".work-entry:last").append(formattedTitle);
		$(".work-entry:last").append(formattedDescription);
	}
}

displayWork();

$(document).click(function(loc){
	var x=loc.pageX;
	var y=loc.pageY;
	logClicks(x,y);
});


$("#mapDiv").append(googleMap);
/*
Code to internationalize the name wherein the secondname is in CAPS
*/
$("#main").append(internationalizeButton);
function inName(oldName,newName){
	var finalName=oldName;
	var names=finalName.split(" ");
	names[0]=names[0].slice(0,1).toUpperCase()+names[0].slice(1).toLowerCase();
	names[1]=names[1].toUpperCase();
	finalName=names.join(" ");
	return finalName;
}

//inName(bio.name);

//console.log(inName("hello baby")==="Hello BABY");

