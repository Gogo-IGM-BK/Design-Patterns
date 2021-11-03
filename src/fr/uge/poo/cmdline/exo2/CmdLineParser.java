package fr.uge.poo.cmdline.exo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

public class CmdLineParser {

	// 2 HashMap
//	private final HashMap<String, Runnable> registeredOptions = new HashMap<>();
//	private final HashMap<String, Consumer<String>> registeredOptionsParameter = new HashMap<>();
//
//	private final HashSet<String> optionsSeen = new HashSet<>();
//	private final ArrayList<String> files = new ArrayList<>();
//
//	public void registerOption(String option, Runnable r) {
//		Objects.requireNonNull(option);
//		Objects.requireNonNull(r);
//		registeredOptions.put(option, r);
//
//	}
//
//	public void registerOptionWithOneParameter(String option, Consumer<String> c) {
//		Objects.requireNonNull(option);
//		Objects.requireNonNull(c);
//		registeredOptionsParameter.put(option, c);
//
//	}
//
//	public Set<String> getOptionsSeen() {
//		return Collections.unmodifiableSet(optionsSeen);
//	}
//
//	public ArrayList<String> getFiles() {
//		return files;
//	}
//
//	public void process(String[] arguments) {
//
//		for (int i = 0; i < arguments.length; i++) {
//			if (registeredOptions.containsKey(arguments[i])) {
//				registeredOptions.get(arguments[i]).run();
//
//			} else if (registeredOptionsParameter.containsKey(arguments[i])) {
//				i++;
//				registeredOptionsParameter.get(arguments[i-1]).accept(arguments[i]);
//			} else {
//
//				files.add(arguments[i]);
//			}
//		}
//		
//	}

	private final HashMap<String, Consumer<String>> registeredOptions = new HashMap<>();
	private final ArrayList<String> files = new ArrayList<>();

	public void registerOption(String option, Runnable r) {
		Objects.requireNonNull(option);
		Objects.requireNonNull(r);
		registeredOptions.put(option, (String) -> 
			r.run()
		);

	}

	public void registerOptionWithOneParameter(String option, Consumer<String> c) {
		Objects.requireNonNull(option);
		Objects.requireNonNull(c);
		registeredOptions.put(option, c);

	}

	public ArrayList<String> getFiles() {
		return files;
	}

	public void process(String[] arguments) {
		boolean bool = false;
		for (int i = 0; i < arguments.length; i++) {
			if (registeredOptions.containsKey(arguments[i]) ) {
				if(i + 1== arguments.length ) {
					registeredOptions.get(arguments[i]).accept("");
					break ;
				}
				registeredOptions.get(arguments[i]).accept(arguments[i+1]);
				bool=true;

			} else {
				if(!bool) {
					files.add(arguments[i]);
				}
				
				bool = false;
			}
//			bool=false;
		}

	}
}