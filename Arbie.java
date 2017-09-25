import java.util.Scanner;
/**
 * Text Game Template
 * Ali, Brent, and Riley
 * @version  0.1
 * 
 * 
 * Arbie is an adventure game where you work to retrieve your memories.
 * 
 * 
 * @authors (your names) 
 * @version (a version number or a date)
 */
public class Arbie
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

    /** Elven sword
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

    // Keep track of the turns taken by player:
    static int turnsTaken;

    // key

    // knife

    
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
            
            //System.out.println();
            //System.out.println("You wake up on the ground with hardly any memories of anything.");
            
            
            
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
        switch( currentRoom )
        {
            case 1: // starting room, courtyard
            {
                System.out.println("You are outside in a dark confined courtyard.");
                System.out.println("Your only light source is coming from the moonlight.");
                System.out.println("There is a door that leads inside of a room to the north of you.");
                break;
            }
            case 2: // main room, #2
            {
                System.out.println("You enter a  square room that is dimly lit by the moon through a skylight.");
                System.out.println("The walls and ceiling are stone and the air is drafty");
                System.out.println("There are four doors, one on each wall.");
                //System.out.println("Pick a door.");
                if( !sword )
                {
                    System.out.println("You see a sword on the ground in front of you.");
                }
                break;
            }
            //go into open room 3
            
             case 3: 
             {
                    System.out.println("There is a door back to the east and the door to the north is locked and has a spell to keep it that way."); 
                    
                    break;
                
             }
             
             case 4:
             {
                 System.out.println("There are multiple candles around the room and a throne  centered against the back wall.");
                  System.out.println("A two meter tall man with a sword stands in the center of the room, about to atack.");
                  System.out.println("You here the door lock behind you.");
                  
                 break;
             }
             
             case 5:
              {
                 System.out.println("You enter a room, a table with a torn paper, the only way out is the way you came.");
                 break;
             }
             case 6:
             {
                 System.out.println("There is a a giant rectangular room the is alomost completely empty except...");
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
            System.out.println("A sturdy sword, worthy of a king");

        if( oilLamp )
        {

            System.out.print("An oil lamp made of brass, ");
            if( oilLampOn )
                System.out.println("the lamp is on.");
            else
                System.out.println("the lamp is off.");
        }

        // add key info

        // add knife info
        System.out.println("A jagged knife with strange markings on it. Seems vaguely farmiliar.");

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
        sword = false;
        swordLocation = 2;  // Elven sword will be located in room 2

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
            System.out.println("1. Display inventory");
            System.out.println("2. Look around");
            System.out.println("3. Move");
            System.out.println();
            int getAction;
            
            if( kb.hasNextInt() )
                getAction = kb.nextInt();
            else
                getAction = 99999999;

            switch( getAction )
            {
                case 0: // choose 0 to stop loop and game
                {
                    menu = false;
                    break;
                }
                case 1: // get inventory
                {
                    displayInventory();
                    break;
                }
                case 2: // look
                {
                    displayCurrentRoom();
                    break;
                }
                case 3: // move
                {
                    move();
                    displayCurrentRoom();
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
        System.out.println("Which direction do you want to move?");

        
        switch(currentRoom)
        {
            case 1: // starting room
            {
                System.out.println("1. North");
                

                break;
            }
            case 2: // cave entrance
            {
                System.out.println("1. North");
                System.out.println("2. East");
                System.out.println("3. South");
                System.out.println("4. West");

                break;
            }
            default:
            {
                break;
            }
        }

        Scanner kb = new Scanner(System.in);
        int direction = kb.nextInt();
        
        moveOk( direction );
    }

    /** @param direction - the direction the player wants to go.
     * 
     */
    public static void moveOk( int direction )
    {
        switch( currentRoom )
        {
            case 1: // Can only move north from this room
            {
                if( direction == 1 )
                    currentRoom = 2; // moved to room 2
                    
                break;
            }
            case 2: // Can only move south from this room
            {
                if( direction == 1 )
                   {
                       currentRoom = 5;
                    }
                if( direction == 2 )
                {
                    currentRoom = 4;
                }
                if( direction == 3 )
                {
                    currentRoom = 1;
                }
                if( direction == 4 )
                {
                    currentRoom = 3;
                }
                break;
            }
            case 3:
            {
                if( direction == 1 )
                {
                    currentRoom = 6;
                }
                if( direction == 2 )
                {
                    currentRoom = 2;
                }
                break;
            }
            case 4: 
            {
                if( direction == 4 )
                {
                    currentRoom = 2;
                }
                break;
            }
            case 5:
            {
                if( direction == 3 )
                {
                    currentRoom = 2;
                }
                break;
            }
            case 6:
            {
                if( direction == 3 )
                {
                    currentRoom = 3;
                }
                break;
            }
            default:
            {
                break;
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
                if( currentRoom == 2 && !sword )
                {
                    System.out.println("You grab the sword and put it in your pack.");
                    sword = true;
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
