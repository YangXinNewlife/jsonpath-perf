package yangxin;

import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by ryan on 17-7-24.
 */
public class Main {
    public static void main(String[] args){
        TestJsonPath();
    }

    public static File[] list_files(String path){
        File root = new File(path);
        if(!root.exists() && !root.isDirectory()){
            System.out.println("Directory, " + path + ", does not exits");
            System.exit(-1);
        }
        return root.listFiles();
    }

    public static void TestJsonPath(){
        System.out.println("===================== BenchMarking Results ====================");
        File[] files = list_files("jsonfiles/");

        for(File f : files){
            String str_json = null;
            try{
                Path path = f.toPath();
                str_json = new String(Files.readAllBytes(path));
                /*
                // Warm-up
                JsonPath.read(str_json, "$.store.book[*].author");
                */
                long num_of_iterations = 10000;

                //long lStart - System.nanoTime();
                long lStart = System.currentTimeMillis();
                /*
                for (int i = 0; i < num_of_iterations; i++){
                    List<String> author = JsonPath.read(str_json, "$.*");
                }
                */

                String res = JsonPath.read(str_json, "$.store.book[0].author");

                //long lEnd - System.nanoTime();
                long lEnd = System.currentTimeMillis();

                System.out.println("Path " + path + " iterations " + num_of_iterations + ": Elasped time : " + (lEnd - lStart) + " ms");
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}

