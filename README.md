# WildPark 

Wild Park Simulation project at WSB Java Training Level 1.

How to start the application:
1. Configure JDK at your computer == set PATH environment variable to be able to use javac and java tools. 
2. Download src/wildpark package.
3. Extract files. You will get 'src' folder with wildpark folder inside.
4. In Command Prompt / Console go to the root folder in which 'src' folder exists. Use cd command to enter the right folder.
5. Create 'out' folder - the foler named 'out'. This 'out' folder must be located in the same directory in which 'src' folder exists. Use the following console command: 


mkdir out  


6. Compile the application - enter the following command:


javac -d out -cp src src/wildpark/WildPark.java


7. Run the application - enter the following command:


java -cp out wildpark.WildPark


