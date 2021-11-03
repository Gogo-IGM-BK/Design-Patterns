package fr.uge.poo.cmdline.exo1;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    static  class PaintOptions{
        private boolean legacy=false;
        private boolean bordered=true;

        public void setLegacy(boolean legacy) {
            this.legacy = legacy;
        }

        public boolean isLegacy(){
            return legacy;
        }

        public void setBordered(boolean bordered){
            this.bordered=bordered;
        }

        public boolean isBordered(){
            return bordered;
        }

        @Override
        public String toString(){
            return "PaintOption [ bordered = "+bordered+", legacy = "+ legacy +" ]";
        }
    }

    public static void main(String[] args) {
        var options = new PaintOptions();
        
        String[] arguments={"-legacy","-no-borders","filename1","filename2"};
        var cmdParser = new CmdLineParser();
        cmdParser.registerOption("-legacy",()->options.setLegacy(true));
        cmdParser.registerOption("-with-borders",()->options.setBordered(true));
        cmdParser.registerOption("-no-borders",()->options.setBordered(false));
        
        cmdParser.process(arguments);
		List<String> result = cmdParser.getFiles();
		List<Path> files = result.stream().map(Path::of).collect(Collectors.toList());
        files.forEach(System.out::println);
        System.out.println(options.toString());

    }
}
