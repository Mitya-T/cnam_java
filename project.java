// Version - 13.12.2021
package nfa031_project_2021;

import java.util.InputMismatchException;
import java.util.Scanner;



public class project {

    public static double evaluation(int total_answers_len, int answered){
        double final_result = ((double)answered/(double)total_answers_len)*100;
        System.out.println("Your result is "+final_result+"%\n");
        if (final_result<33.33){
            System.out.println("You have got C... Work harder.");
        } else if (final_result>33.33 && final_result<66.66){
            System.out.println("You have got B - tsokay...");
        } else {
            System.out.println("You have got A, Bravo!!!");
        }
        return final_result;
    }


    public static void main(String[] args) {

        System.out.println("Welcome to questionnaire program. \nWriten by TRUBETSKOY DIMITRI | dmitrii.trubetskoy@gmail.com\n");

        while(true){


            Scanner s = new Scanner(System.in);
            System.out.println("How many questions?");
            try{
                int howManyQuestions = s.nextInt();

                System.out.println("Thank you, remember that you are not obliged to write all "+howManyQuestions+" questions. Less, but no more than "+howManyQuestions);


                Scanner sc = new Scanner(System.in);

                String [] questions = new String [howManyQuestions];
                int [] responses = new int [questions.length];
                int [] howManyAnswers = new int [questions.length];

                int question_counter = 0;
                int right_answer;
                int answers_counter = 0;


                while(true) {
                    String q = "";
                    int resp_counter = 1;
                    System.out.println("Please enter QUESTION number " + (question_counter+1)+": (nomore for no more questions)");
                    String question_input = sc.nextLine();
                    if(question_input.equals("nomore")) {
                        break;
                    } else {
                        q+="\tQuestion \u2116 "+(question_counter+1)+" is: \""+question_input+"\"\n";

                        while(true) {

                            System.out.println("Please enter an ANSWER \u2116"+resp_counter+" : (press ENTER for no more responses)");
                            String rep = sc.nextLine();

                            if(rep.equals("")) {

                                Scanner sca = new Scanner(System.in);
                                System.out.println("Resp counter is "+resp_counter+". Real answers number is "+(resp_counter-1));

                                System.out.println("The correct answer is \u2116...");
                                right_answer = sca.nextInt();

                                while (right_answer > resp_counter - 1 || right_answer <= 0) {
                                    System.out.println("Nope, you there are only " + (resp_counter - 1) + " answers");
                                    System.out.println("TRY AGAIN! \tThe correct answer is \u2116...");
                                    right_answer = sca.nextInt();
                                }
                                responses[question_counter] = right_answer;
                                break;
                            } else {
                                q+=resp_counter+": "+rep+"\n";

                                resp_counter+=1;
                                answers_counter +=1;

                            }
                            questions[question_counter]=q;
                        }
                    }
                    System.out.println("END OF THE question...");
                    System.out.println("NUMBER OF ANSWERS IS "+answers_counter+"\n");

                    howManyAnswers[question_counter]=answers_counter;
                    answers_counter=0;
                    question_counter+=1;

                }

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n Questions are");
                for(String x : questions) {
                    if(x!=null)
                        System.out.println(x);
                }

                System.out.println("\n (DEVELOPER MODE) Right answers are:");
                for(int y : responses) {
                    if (y!=0)
                        System.out.print(y+" ");
                }


                System.out.println("Please press ENTER...");
                sc.nextLine();

                while (true) {
                    System.out.println("\nStart quiz? y/n");
                    String decision = sc.nextLine();


                    switch (decision) {
                        case "y":
                            System.out.println("-= LET THE GAME BEGIN =-");


                            int user_points = 0;



                            for (int i=0;i<questions.length;i++){


                                System.out.println(questions[i]);
                                System.out.println("Number of answers is "+howManyAnswers[i]);
                                System.out.println("Please choose an answer:");
                                int user_answer = sc.nextInt();

                                while(user_answer<=0 || user_answer>howManyAnswers[i]) {
                                    System.out.println("I told you already! Number of answers is "+howManyAnswers[i]);
                                    System.out.println("please TRY AGAIN:");
                                    user_answer = sc.nextInt();
                                }


                                if(user_answer==responses[i]){
                                    user_points+=1;
                                    System.out.println("CORRECT! next question is...");
                                } else {
                                    System.out.println("WRONG ANSWER! Proceed to the next question...");
                                }

                            }


                            System.out.println("Your result is "+user_points+"/"+responses.length+" points!");

                            // Make functions

                            System.out.println("-= SEE U NEXT TIME =-");

                            evaluation(responses.length, user_points);

                            break;
                        case "n":
                            System.out.println("\t-= END OF THE LINE =-\n-= MIND THE GAP BETWEEN THE TRAIN AND THE PLATFORM =-");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("You must choose y (YES) or n (NO)");
                    }

//                    System.exit(0); // or write BREAK after here
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("\nYou have asked to submit only limited number of questions, sorry");
            }catch (InputMismatchException e){
                System.out.println("Only numbers, sorry");
            }

            Scanner x = new Scanner(System.in);
            System.out.println("PLAY AGAIN? y/n");
            String again = x.nextLine();


            if (again.equals("n")){
                System.out.println("\t-= END OF THE LINE =-\n-= MIND THE GAP BETWEEN THE TRAIN AND THE PLATFORM =-");
                System.exit(0);
            }

        }
    }
}
