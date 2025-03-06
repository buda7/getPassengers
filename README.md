The GetPassengers app allows users to input a list of airline passengers and display them on the main screen.
MainActivity – Displays the passenger list and has a button to navigate to the second screen.
GetPassengers Activity – Allows users to add passengers (first name, last name, phone number) and send the list back to MainActivity.
When the user adds passengers in GetPassengers and clicks “Return List,” the data is passed back to MainActivity.
The MainActivity then displays the returned list.

Problem: Passengers data was not being sent to MainActivity and Input fields didn’t clear after adding a passenger
Solution: Used an ArrayList to store all passengers and sent them as separate key-value pairs using a for loop. Used .text.clear() on 
function enterPassenger to clear input fields.

Key Learnings:
Learned how to pass multiple values between activities using Intent.putExtra().
Gained experience in ConstraintLayout to properly align UI components.

Future Improvements:
Save the passenger list using local database so that data isn't lost when the app restarts.
Allow users to delete or modify passenger details.
Lear to Implement a RecyclerView instead of a TextView for better list management.


