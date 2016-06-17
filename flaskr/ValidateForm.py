import re
class ValidateEmail(Exception):
	pass

class ValidatePhoneNumber(Exception):
	pass

class ValidateAll(Exception):
	pass

#function to validate the form fields
def ValidateMethod(name,email,phone_number,employee_name):

	# Check if all the fields are non-empty and raise an error otherwise
	if not name or not email or not phone_number or not employee_name:
		raise ValidateAll
	
	else:
		if not re.match(r'^[a-zA-Z0-9._]+@([a-zA-Z])+\.([a-zA-Z]+)$', email):
			raise ValidateEmail
			
		if not re.match(r'^(\d{3})\-(\d{3})\-(\d{4})$',phone_number):
			raise ValidatePhoneNumber
			
		
	

		



