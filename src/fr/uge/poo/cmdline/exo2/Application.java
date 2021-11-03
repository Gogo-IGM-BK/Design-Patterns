package fr.uge.poo.cmdline.exo2;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    static  class PaintOptions{
        private boolean legacy=false;
        private boolean bordered=true;
        private String name ;
        private int width = -1;
        public void setLegacy(boolean legacy) {
            this.legacy = legacy;
        }

        public boolean isLegacy(){
            return legacy;
        }
        
        public int getWidth(){
        	if(width>0) {
        		return width;
        	}
            throw new IllegalAccessError();
        }
        
        public String getName(){
        	if(name !=null) {
        		return name;
        	}
            throw new IllegalAccessError();
        }

        public void setBordered(boolean bordered){
            this.bordered=bordered;
        }
        
        public void setName(String name){
            this.name = name;
        }
        
        public void setWidth(String width){
            this.width = Integer.parseInt(width);
        }

        public boolean isBordered(){
            return bordered;
        }

        @Override
        public String toString(){
        	String tmp ="PaintOption [";
        	if(name!=null) {
        		tmp+=" window name = "+name +",";
        	}
        	if (width!= -1) {
        		tmp+=" width = " + width +",";
        	}
        	tmp.substring(0, tmp.length()-1);
            return tmp+" bordered = "+bordered+", legacy = "+ legacy +" ]";
        }
    }

    public static void main(String[] args) {
        var options = new PaintOptions();
        
        String[] arguments={"-border-width", "8","-window-name", "test","filename1","filename2","-legacy"};
        var cmdParser = new CmdLineParser();
        cmdParser.registerOption("-legacy",()->options.setLegacy(true));
        cmdParser.registerOptionWithOneParameter("-window-name",(String)->options.setName(String));
        cmdParser.registerOptionWithOneParameter("-border-width",(String)->options.setWidth(String));
        cmdParser.registerOption("-no-borders",()->options.setBordered(false));
        cmdParser.process(arguments);
		List<String> result = cmdParser.getFiles();
		List<Path> files = result.stream().map(Path::of).collect(Collectors.toList());
        files.forEach(System.out::println);
        System.out.println(options.toString());

    }
}
