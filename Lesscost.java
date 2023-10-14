package Jabo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import javafx.util.Pair;

public class Lesscost {
    
     int check=0;
    int lastVal = 1;
    String source, destination;
   String pathAns="";
   String PathDes="";
    Lesscost(String so, String dos) {
        source = so;
        destination = dos;

    }

    public void solve() throws FileNotFoundException, IOException 
    {
        
        int i;
        ArrayList<ArrayList<Pair<Integer,Pair<String,Pair<Integer,Pair<Integer,String>>>>>>adj=new ArrayList<>();
        for(i=0;i<50000;i++)
        {
            adj.add(new ArrayList<>());
            
        }
        source = source.toLowerCase();
        destination = destination.toLowerCase();
        Map<String, Integer> code = new HashMap<>();
        Map<Integer, String> decode = new HashMap<>();
        if (!code.containsKey(source)) {
            code.put(source, lastVal);
            decode.put(lastVal, source);
            lastVal++;
        }
        if (!code.containsKey(destination)) {
            code.put(destination, lastVal);
            decode.put(lastVal, destination);
            lastVal++;
        }
        File file = new File("Data.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String from, to, medium, note;
            int timee, cost;
            from = input.next();
            to = input.next();
            medium = input.next();
            timee = input.nextInt();
            cost = input.nextInt();
            note = input.nextLine();
            from = from.toLowerCase();
            to = to.toLowerCase();
            //System.out.println(from+" "+to+" "+medium+" "+timee+" "+cost+" "+note);
            if (!code.containsKey(from)) {
                code.put(from, lastVal);
                decode.put(lastVal, from);
                lastVal++;
            }
            if (!code.containsKey(to)) {
                code.put(to, lastVal);
                decode.put(lastVal, to);
                lastVal++;
            }
            //Create the graph
            int u,v;
            u=code.get(from);
            v=code.get(to);
            //create the pair
            Pair<Integer,String>p1=new Pair<>(cost,note);
            Pair<Integer,Pair<Integer,String>>p2=new Pair<>(timee,p1);
            Pair<String,Pair<Integer,Pair<Integer,String>>>p3=new Pair<>(medium,p2);
            Pair<Integer,Pair<String,Pair<Integer,Pair<Integer,String>>>>p4=new Pair<>(v,p3);
            Pair<Integer,Pair<String,Pair<Integer,Pair<Integer,String>>>>p5=new Pair<>(u,p3);
            adj.get(u).add(p4);
            adj.get(v).add(p5);

        }
        //storing information
        Map<Integer,String>forMedium=new HashMap<>();
        Map<Integer,Integer>forTime=new HashMap<>();
        Map<Integer,Integer>forCost=new HashMap<>();
        Map<Integer,String>forNote=new HashMap<>();
       PriorityQueue<Pair<Integer, Integer>> pq =new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        int dis[]=new int[100000];
        int parent[]=new int[100000];
        for(i=0;i<=lastVal+2;i++)
        {
            dis[i]=100000000;
        }
        int sourceInt=code.get(source);
        dis[sourceInt]=0;
        parent[sourceInt]=sourceInt;
        Pair<Integer,Integer>p13=new Pair<>(0,sourceInt);
        pq.add(p13);
        while(pq.size()!=0)
        {
            int mNode=pq.peek().getValue();
            int mCost=pq.peek().getKey();
            pq.remove();
            for(i=0;i<adj.get(mNode).size();i++)
            {
                int adjNode=adj.get(mNode).get(i).getKey();
                String adjMedium=adj.get(mNode).get(i).getValue().getKey();
                int adjTime=adj.get(mNode).get(i).getValue().getValue().getKey();
                int adjCost=adj.get(mNode).get(i).getValue().getValue().getValue().getKey();
                String adjNote=adj.get(mNode).get(i).getValue().getValue().getValue().getValue();
                if((mCost+adjCost)<dis[adjNode])
                {
                    dis[adjNode]=mCost+adjCost;
                    Pair<Integer,Integer>pinq1=new Pair<>((int)dis[adjNode],adjNode);
                     pq.add(pinq1);
                     parent[adjNode]=mNode;
                     forMedium.put(adjNode, adjMedium);
                     forTime.put(adjNode,adjTime);
                     forCost.put(adjNode,adjCost);
                     forNote.put(adjNode,adjNote);
                }
                
                
            }
            
           
         
        }
        
         ArrayList<String>ans=new ArrayList<>();
            int node;
         node=code.get(destination);
         if(dis[node]==100000000)
         {
             check=1;
             return;
         }
         while(parent[node]!=node)
         {
             String ss;
             ss=decode.get(node);
             ans.add(ss);
             node=parent[node];
             
         }
         int numOfWord=1;
         int numofWord2=0;
         ans.add(decode.get(sourceInt));
        Collections.reverse(ans);
        pathAns="The path is : \n";
        pathAns+=ans.get(0);
        PathDes="\n\nPath Description : \n";
        int totalCost=0;
        int totalTime=0;
        
        for(i=1;i<ans.size();i++)
        {
            int minutes,hour,second;
            second=forTime.get(code.get(ans.get(i)));
            hour=second/3600;
            second=second%3600;
            minutes=second/60;
            second=second%60;
            PathDes+="From "+ans.get(i-1)+" to "+ans.get(i)+" You Will go By "+forMedium.get(code.get(ans.get(i)))+" The Cost is ";
            PathDes+=forCost.get(code.get(ans.get(i)))+" Taka"+". Needed Time is ";
             if(hour>0)
             {
                 PathDes+=hour+" Hour. ";
             }
             if(minutes>0)
             {
                  PathDes+=minutes+" Minutes. ";
             }
             if(second>0)
             {
                  PathDes+=second+" second.";
             }
             PathDes+="\n";
            PathDes+=forNote.get(code.get(ans.get(i)))+".\n";
            totalTime+=forTime.get(code.get(ans.get(i)));
            totalCost+=forCost.get(code.get(ans.get(i)));
            //short description
            pathAns=pathAns+" -> ";
            numOfWord++;
            pathAns=pathAns+ans.get(i);
            pathAns=pathAns+"[ By "+forMedium.get(code.get(ans.get(i)))+" ]";
            numOfWord+=4;
            if(numOfWord>=13)
            {
                pathAns+='\n';
                numOfWord=0;
            }
            
        }
        //System.out.println(pathAns);
          int minutes,hour,second;
            second=totalTime;
            hour=second/3600;
            second=second%3600;
            minutes=second/60;
            second=second%60;
            PathDes+="\n\n";
            PathDes+="Total time is ";
            if(hour>0)
             {
                 PathDes+=hour+" Hour.";
             }
             if(minutes>0)
             {
                  PathDes+=minutes+" Minutes.";
             }
             if(second>0)
             {
                  PathDes+=second+" second.";
             }
             PathDes+="\n";
             PathDes+="Total Cost is "+totalCost+" Taka.\n";
             PathDes+="Please note that the total time and cost of the journey can vary depending on factors\n";
             PathDes+="Thanks For Use JABO.\nBest of luck for your Jurney.\n";
              pathAns+=PathDes;   
     
    }

}
