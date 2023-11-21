# NumberGuesserGame
A simple "Guess the number" game.There is an option to exactly guess from 1 to 10 ,or guess if the next number is Lower,Equal or Higher than the current from 0 to 100. 

## Main Frame
Here is the information for the starting window,which only gives you the option to choose to play "Guess the Number" 
or "Higher,Lower,Equal"(that are different classes).

![image](https://github.com/Cavani99/NumberGuesserGame/assets/75423586/96403bda-b083-4ae5-aa53-679991193041)

## GuessGame class 
Starts the "Number Guesser"game where you have to guess a random number from 1 to 10.You also have 10 lives and you lose lives for every wrong guess,based on the absolute value when you substract the right number from the number guessed.After every guess a new right number is generated.If you have guessed right you heal 5 lives.

![image](https://github.com/Cavani99/NumberGuesserGame/assets/75423586/843af3fd-3fbc-4b33-abce-82269811fb4d)

Wrong Guess

![image](https://github.com/Cavani99/NumberGuesserGame/assets/75423586/8fb6cd63-f154-498c-9826-d59b962fe818)


The Window when you have 0 lives

![image](https://github.com/Cavani99/NumberGuesserGame/assets/75423586/9389b3b1-93ac-416e-83e7-82f9d65fa6ec)

There is also UppercaseDocumentFilter class that restricts you to write only digits from 0 to 9.

## RangeGame class

Here you get a random number and you have to guess if the next one is going to be of higher,equal or lower value.The range of the numbers here is from 0 to 100 and you have 
50 lives instead(because you can lose more),you lose lives based on the difference between the random number and the previus number if you have guessed wrong.

![image](https://github.com/Cavani99/NumberGuesserGame/assets/75423586/61c61e46-a2f4-469b-b077-a542139c296a)


When you fail 

![image](https://github.com/Cavani99/NumberGuesserGame/assets/75423586/32fc6a7e-d59e-4594-a36b-7fdc29fd92db)



You can try the program at out/artifacts/...
