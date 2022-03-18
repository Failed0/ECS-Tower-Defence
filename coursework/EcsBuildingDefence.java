import building.Building;

import java.io.*;
import bugs.*;
import students.*;


public class EcsBuildingDefence {

    public static void main(String[] args) {

        int topFloor = Integer.parseInt(args[0]);
        int constructionPoints = Integer.parseInt(args[1]);
        String file = args[2];
        int knowledgePoints = Integer.parseInt(args[3]);

        Building b = new Building(topFloor,constructionPoints);
        Team t = new Team(knowledgePoints);

        /**
        * Reading the file
        */
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String l = bufferedReader.readLine();
            Battle btl = new Battle(t,b);
            int waveNumber = 1;
            while(l != null){
                System.out.println();
                System.out.println("Incoming Wave" +waveNumber);
                parseBugWave(b,l);
                for(int i =0; i<8*topFloor; i++){
                    btl.step();
                    if(btl.b.getConstructionPoints() <= 0){
                      /**
                      * Building Defeated
                      */
                        System.out.println("Building was Defeated!!!");
                        bufferedReader.close();
                        return;
                    }
                    if(btl.b.getAllBugs().length == 0){
                        /**
                         * All the bugs are successfully removed from the building
                         */
                        System.out.println("Students successfully saved the building");
                        bufferedReader.close();
                        break;
                    }
                }
                l = bufferedReader.readLine();
                waveNumber++;
            }
            bufferedReader.close();
            System.out.println("Building is Safe");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Splitting String
     */
    private static void parseBugWave(Building b,String l){
        String[] stringOfBugs = l.split(";");

        System.out.println("------------------------------------");
        for(String bs: stringOfBugs){
            String name = bs.substring(0,bs.indexOf("("));
            String type = bs.substring(bs.indexOf("(") + 1,bs.indexOf(","));
            bs = bs.substring(bs.indexOf(",")+1);
            int level = Integer.parseInt(bs.substring(0,bs.indexOf(",")));
            bs = bs.substring(bs.indexOf(",")+1);
            int step = Integer.parseInt(bs.substring(0,bs.indexOf(")")));
            Bug bug = null;

            if(type.equals("CMB")){
                bug = new ConcurrentModificationBug(name,level,step);
            }else if (type.equals("NTB")){
                bug = new NoneTerminationBug(name,level,step);
            }else if(type.equals("NPB")){
                bug = new NullPointerBug(name,level,step);
            }

            if(b.addBug(bug) != -1){
                System.out.println("Done adding" + bug);
            }
        }
        System.out.println("------------------------------------");
        System.out.println();
    }
}