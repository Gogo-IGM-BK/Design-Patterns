package fr.uge.poo.cmdline.exo1;

import java.util.*;

public class CmdLineParser {

    private final HashMap<String,Runnable> registeredOptions = new HashMap<>();
    private final HashSet<String> optionsSeen = new HashSet<>();
    private final ArrayList<String> files = new ArrayList<>();

    public void registerOption(String option,Runnable r) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(r);
        registeredOptions.put(option,r);
        
    }

    public Set<String> getOptionsSeen() {
        return Collections.unmodifiableSet(optionsSeen);
    }
    
    public ArrayList<String> getFiles() {
    	return files;
    }
    
    public void process(String[] arguments) {
        
        for (String argument : arguments) {
            if (registeredOptions.containsKey(argument)) {
                registeredOptions.get(argument).run();
                
            } else {
                files.add(argument);
            }
        }
    }
}