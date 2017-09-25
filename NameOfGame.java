import java.util.Scanner;
/**

 * Arbie
 * 
 * 
     * @authors (your names) 
 * @version 0.1
 */
public class NameOfGame
{
    /** 
     * 
     * Field variables Go Up Here
     * 
     */
    // Declare any field, aka world variables that you need here.
    // For example, you could assign a number to each room so that we know where the player
    // is currently located. Uses key word static in declaration.
    // Example:
    static int currentRoom;

    // If you want the player to have character stats, declare them here as a static variable.
    // Examples:
    static String playerName;
    static int playerHealth;
    static int playerStamina;

    // If you want to have items that the player can find in game and add to their 'inventory',
    // declare item variables here. We can use booleans to represent if the player has the item
    // in their inventory or not.
    // Examples:
    
    /** Sword
     * 
     *  taken name: sword, elvensword
     */
    static boolean sword;
    static int swordLocation; // Keep track of item location.
    
    /** Oil lamp
     * 
     *  starts in pack
     *  taken name: lamp, oillamp
     *  useable: lamp
     */
    static boolean oilLamp;
    static boolean oilLampOn;
    
    //key
    
    //knife
    
    
    
    
    // End of field variables

    /** Prompts the user to play game or quit.
     */
    public static void main(String[] args)
    {
        boolean run = true;
        do
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("Prompt the user here to begin game or quit: ");
            String response = sc.next().toLowerCase();

            if( response.equals("begin") )
            {
                startGame();
                run = false; // after our game is over, exit the loop
            }
            else if( response.equals("quit") )
            {
                run = false;
            }
            else
            {
                System.out.println("Display error message.");
            }

        }while(run);
    }

    /** Displays the introduction to the game.  Includes any instructions you may want to give
     *  the user.
     */
    public static void displayIntro()
    {
        System.out.println("Display the full introduction of your game to the user here.");
        System.out.println("For now, all commands are limited to one word at a time.");

        System.out.println();
        System.out.println();
    }

    /** Displays a description of the room where the character is currently located.
     */
    public static void displayCurrentRoom()
    {
        swu=itch ( currentRoom )
        {
            case 1: // starting room
            {
                System.out.println("You are in a cave with very little light.");
                System.out.println("To the north you can see faint sunlight.");
                break;
            }
            case 2: // north of starting room
            {
                System.out.println("There is an entrance to a dark cave south of you.");
                System.out.println("It seems vaguely familiar.");
                if( !elvenSword )
                {
                    System.out.println("You see an elven sword on the ground in front of you.");
                }
                break;
            }
            default:
            {
                break;
            }
        }
    }

    /** Displays all items in player's inventory.
     */
    public static void displayInventory()
    {
        if( sword )
            System.out.println("A sword with a sharpe blade");

        if( oilLamp )
        {

            System.out.print("A simple oil lamp.  It is currently turned ");
            if( oilLampOn )
                System.out.println("on.");
            else
                System.out.println("off.");
        }
        
        //key info
        
        //knife info
    }

    /** Initializes static variables
     */
    public static void init()
    {
        /** 
         * Player creation
         */
        // Prompt user for character name.
        System.out.print("What is your name? ");
        Scanner kb = new Scanner(System.in);
        playerName = kb.next();
        // Player stats
        playerHealth = 5;
        playerStamina = 5;
        
        
        /** 
         * Starting room number:
         */
        currentRoom = 1;

        /** 
         * Items:
         * Set all items that we don't want the user to start with to false,
         * and if we want them to start with an item set to true.
         */
        elvenSword = false;
        elvenSwordLocation = 2;  // Elven sword will be located in room 2

        oilLamp = true; // starting with oil lamp in inventory
        oilLampOn = false;

    }

    /** Starts a new game
     */
    public static void startGame()
    {
        displayIntro();  // Display the game's intro!

        init(); // Initialize game variables

        displayCurrentRoom();  // Display the starting room description

        boolean menu = true;
        do
        {
            Scanner kb = new Scanner(System.in);
            
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println();


            int getAction = kb.nextInt();

            switch( getAction )
            {
                case 0:
                {
                    menue = false;
                    break;
                }
                case 1:
                {
                    displayInventory();
                    break;
                }
                case 2:
                {
                    displayCurrentRoom();
                    break;
                }
                case 3:
                case 4:
                {
                    takeItem();
                    break;
                }
                case "n":
                case "north":
                case "s":
                case "south":
                case "e":
                case "east":
                case "w":
                case "west":
                {
                    move( getAction );
                    break;
                }
                
                case "go":
                case "walk":
                case "run":
                case "jog":
                {
                    System.out.println("Which direction do you want to " + getAction + "?");
                    break;
                }
                
                case "quit":
                {
                    menu = false;
                    break;
                }
                
                default:
                {
                    System.out.println("Error message here, action not defined");
                    break;
                }

            }
            
            System.out.println(); // print a space between attempted actions

        }while( menu );
    }

    /** 'Move' command
     * 
     * Moves the player in a given direction.
     * 
     * @param direction - the direction the player wants to go.
     */
    public static void move()
    {
        System.out.println("Whitch direction do u want to go?");
        if( canMove(direction) )
        {
            switch(currentRoom)
            {
                case 1: // starting room
                {
                    System.out.println("1. North");
                    
                    break;
                }
                case 2: // cave entrance
                {
                    System.out.println("1. South");
                    
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
        
        Scanner kb = new Scanner(System.in);
        int direction = kb.nextInt();
        
        moveOk ( direction );
        
        displayCurrentRoom();
    }

    /** @param direction - the direction the player wants to go.
     * 
     *  @return true if the player's chosen direction is allowed from their current location,
     *          false otherwise.
     */
    public static void moveOk( int direction )
    {
        switch( currentRoom )
        {
            case 1: // Can only move north from this room
            {
                if( direction == 1)
                currentRoom = 2;
            }
            case 2: // Can only move south from this room
            {
                if(direction == 1)
                   currentRoom = 2;
                   
                   break;
            }
            default:
            {
                return false;
            }
        }
    }

    /** 'Take' command
     * 
     * Takes an item from the ground
     * 
     * @Preconditions: Player must be in the same room as item
     * 
     * @Postconditions: If item is found, item placed in player's pack
     */
    public static void takeItem()
    {
        System.out.print("What item would you like to take? ");
        Scanner kb = new Scanner(System.in);
        String itemToGet = kb.next().toLowerCase();

        switch( itemToGet )
        {
            case "sword":
            case "elvensword":
            {
                if( currentRoom == 2 && !elvenSword )
                {
                    System.out.println("You grab the elven sword and put it in your pack.");
                    elvenSword = true;
                }
                else
                {
                    System.out.println("I don't see that here.");
                }
                break;
            }
            
            case "oillamp":
            case "lamp":
            {
                System.out.println("That is already in your pack.");
                break;
            }
            
            default:
            {
                System.out.println("I don't see that here.");
                break;
            }
        }
    }
    
    /** 'Use' command
     * 
     * Use an item.
     * 
     * @Preconditions: Item must be in player pack.
     */
    public static void useItem()
    {
        System.out.print("What item would you like to use from inventory? ");
        Scanner kb = new Scanner(System.in);
        String itemToUse = kb.next().toLowerCase();

        switch( itemToUse )
        {
            case "oillamp":
            case "lamp":
            {
                String onOff = "off";
                if( !oilLampOn )
                {
                    onOff = "on";
                }
                
                System.out.println("You turn " + onOff + " the oil lamp.");
                oilLampOn = !oilLampOn;
                break;
            }
            
            default:
            {
                System.out.println("I don't see how to use that.");
                break;
            }
        }
    }
}
