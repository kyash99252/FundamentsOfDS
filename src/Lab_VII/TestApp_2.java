package Lab_VII;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
class Information{
    public String name;
    public boolean type;
    public long size;
    public long date;
}
public class TestApp_2
{
    public static GeneralTree<Information> inforTree = new GeneralTree<Information>();
    public static void main(String[] args)
    {
        GeneralTree<Information> inforTree = new GeneralTree<>();
        File f = new File("C:\\Users\\Yash Kadam\\Downloads");
        Information r = new Information();
        setInformation(r, f);
        inforTree.addRoot(r);
        constructTree(inforTree.root(), f);
        Iterable<Position<Information>> iter = inforTree.positions();
        DateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
        for(Position<Information> i : iter){
            String Type;
            if(i.getElement().type)
                Type = "Directory";
            else
                Type = "File";
            System.out.println(i.getElement().size + "\t" + sdf.format(i.getElement().date) + "\t" +  i.getElement().name + "\t" + Type);
        }
    }

    public static Information setInformation(Information i, File root){
        i.name = root.getName();
        i.date = root.lastModified();
        i.type = root.isDirectory();
        i.size = root.length();
        return i;
    }
    public static Position<Information> addNode(Position<Information> parent, File root){
        Information i = new Information();
        i = setInformation(i, root);
        return inforTree.addChild(parent, i);
    }
    public static void constructTree(Position<Information> parent,File root){
        if(root.isDirectory()) {
            for (String childname : root.list()) {
                File child = new File(root, childname);
                Position<Information> temp = addNode(parent, child);
                constructTree(temp, child);
            }
        }

    }
}

