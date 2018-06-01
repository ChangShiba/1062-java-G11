import java.io.BufferedReader;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;  
  
//地圖配置  
public class Map {  
      
    //數據容器
    public ArrayList<String> list = new ArrayList<String>();  
      
    public int [][] map=null;  
      
    public  int[][] readMap() throws Exception {  
        // map.txt輸入數據(frame呼叫偵測)
        FileInputStream fis = new FileInputStream("map.txt");  
        InputStreamReader isr = new InputStreamReader(fis);  
        BufferedReader br = new BufferedReader(isr);  
          
        //轉型
        String value =br.readLine();  
          
        while(value!=null){  
            //將讀到的加入容器中
            list.add(value);  
            value =br.readLine();  
        }  
          
        br.close();  
          
        //得到多少行多少列  
        int row=list.size();  
        int cloum=0;  
      
        for (int i = 0; i < 1; i++) {  
            String str=list.get(i);  
            String [] values=str.split(",");  
            cloum=values.length;  
        }  
          
          
        map = new int [row][cloum];  
         //將讀到的文字轉成整數，把值給map 
       for (int i = 0; i < list.size(); i++) {  
           String str=list.get(i);  
            String [] values=str.split(",");  
            for (int j = 0; j < values.length; j++) {  
                map[i][j]=Integer.parseInt(values[j]);  
            }  
    }  
      return map;  
  
    }  
  
}  