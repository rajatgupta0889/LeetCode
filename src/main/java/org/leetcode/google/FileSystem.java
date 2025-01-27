package org.leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    Map<Integer,Integer> cache = new HashMap<>();
    public int calculateSize(Entity entity){

        if(cache.containsKey(entity.id)){
            return cache.get(entity.id);
        }

        if(entity.type.equalsIgnoreCase("file")){
            return entity.size;
        }

        int totalSize = 0;

        for (Entity child : entity.children) {
            totalSize += calculateSize(child); // Recursive call
        }
        cache.put(entity.id, totalSize);
        return totalSize;
    }


    public static void main(String[] args) {
        Entity file1 = new Entity(1, "file", "file1", 10);
        Entity file2 = new Entity(2, "file", "file2", 20);
        Entity file3 = new Entity(3, "file", "file3", 15);
        Entity file4 = new Entity(4, "file", "file4", 30);

        Entity subDir2 = new Entity(5, "directory", "subDir2", 0);
        subDir2.children.add(file4);

        Entity subDir1 = new Entity(6, "directory", "subDir1", 0);
        subDir1.children.add(file3);
        subDir1.children.add(subDir2);

        Entity root = new Entity(7, "directory", "root", 0);
        root.children.add(file1);
        root.children.add(file2);
        root.children.add(subDir1);

        FileSystem fileSystem  = new FileSystem();

        System.out.println("Total size: " + fileSystem.calculateSize(root));

        System.out.println("Total size: " + fileSystem.calculateSize(root));
    }
}
