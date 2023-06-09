# Java Challenge
## Bowling Score Calculator


![alt text](https://media.istockphoto.com/vectors/bowling-score-sheet-blank-template-scoreboard-with-game-objects-vector-id515068760?s=612x612 
"Bowling")

### Description
This project is a console application developed in Java.  
It serves to provide the total score after a 10 pin bowling match.
The application accepts a file with the scores of one or multiple bowlers,
and it will return the pinfall display as well as the scores of each frame.

### How It Works
Bowling Score Calculator is designed to accept a file such as the one provided below. The file should contain the player name, and their scores (tab separated).


![Input](https://i.imgur.com/Dommnu1.png "Sample input file")

Objects are then created from the input to represent the scoring frames (each bowling round). The scores are also calculated systematically as these frames are generated.

The pinfall scores, and the running score per bowler from the file is then generated. An example provided below:


![Output](https://i.imgur.com/ry5ZR3U.png "Sample output")


---
---

### Demo & Explanation

![Demo](https://s8.gifyu.com/images/ezgif.com-gif-maker-15ba49c94c1119cf5.gif)

You will be prompted to enter the location of your test file. Sample files are provided to be used for this project within the test resource folder. (\JavaChallenge\src\test\resources\).

After being prompted to enter the file path, the equivalent pinfall record and score will be displayed on the screen. After which, you will be asked if you want to generate a file with the score information.

These files will be generated under the "\JavaChallenge\scores\" folder as text files.

---
---

### How To Run

#### Cloning the project
- Create a folder on your local machine in preparation to clone this project.
- Run the following command in the terminal (CMD, or GIT BASH) to clone the repository```git clone https://git.jobsity.com/dane.jackson/JavaChallenge.git```
  
#### Running the jar file
- You should see a folder called "JavaChallenge", this is the project folder.
- On Windows, navigate to the ```JavaChallenge/out/artifacts/JavaChallenge_jar/``` folder.
- In the address bar, type "cmd" and press Enter to launch command prompt.
  
![Example gif](https://s8.gifyu.com/images/ezgif.com-gif-maker09233aef041dcdfc.gif)


- Type in the following command to run the compiled jar file:
  ```java -jar JavaChallenge.jar```
  
#### Opening in IntelliJ

- Open IntelliJ and click File > Open, then navigate to this "JavaChallenge" folder and click OK.

- Once opened, click File > Project Structure > Libraries > Select "Java Challenge", then click the "-" icon to remove it > Click OK on pop up
  
![Removing library from project](https://s8.gifyu.com/images/ezgif.com-gif-maker-2710ab76aa3e65800.gif)

- Next click the "+" icon to add a new Library > Click "From Maven..." > Copy ```junit:junit:4.13.1``` and paste this value in the text box > Click OK.

- Click the "+" icon again, and repeat the step above, copying and pasting ```org.junit.jupiter:junit-jupiter:5.7.0``` instead.

- Click "Apply"

![Adding JUnit libraries](https://s8.gifyu.com/images/ezgif.com-gif-maker-321f29ad10548f257.gif)

- In the Project Structure window from above, go to Project > Select version 16 under Project SDK > Ensure that "16 - Records, patterns, local enums and interfaces" is selected under Project language level.

![Setting SDK](https://s8.gifyu.com/images/ezgif.com-gif-maker-4febb4f5839b1c1af.gif)

- We may need to invalidate our cache and reload the project. Click on File > Invalidate Caches... > Make sure "Clear downloaded shared indexes" is selected > Click "Invalidate and Restart"

- Finally, when the project has opened and loaded after the restart, select Add Configuration > Add New > Application > Click the clipboard icon in the "Main Class" text box, you should see the Main class of the project as a dropdown. Select it and click "OK".

- In the Name textbox, we can type "Main".

![Add Configuration](https://s8.gifyu.com/images/ezgif.com-gif-maker-5cc688303893b1b92.gif)

Now the project should be set up in IntelliJ with JUnit for the test cases to run correctly.

### Current Limitations 
- Bowling scores with less than 10 rounds is not permitted; scores can only be generated if all 10 bowling rounds are provided.
- The displaying of Fouls are represented as 0 on the score output.
- Reads one file each run.

