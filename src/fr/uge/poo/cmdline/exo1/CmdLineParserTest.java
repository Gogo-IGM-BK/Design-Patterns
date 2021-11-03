package fr.uge.poo.cmdline.exo1;

import fr.uge.poo.cmdline.exo1.Application.PaintOptions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("static-method")
class CmdLineParserTest {

	@Test
	public void processShouldFailFastOnNullArgument() {
		var parser = new CmdLineParser();
		assertThrows(NullPointerException.class, () -> parser.process(null));
	}


	@Test
	public void notNull() {
		var options = new PaintOptions();
		assertEquals(false, options == null);

	}

	@Test
	public void initializeWithNull() {
		var options = new PaintOptions();
		var cmdParser = new CmdLineParser();
		assertAll(() -> assertThrows(NullPointerException.class,()-> cmdParser.registerOption(null,()->options.setLegacy(true))), () ->assertThrows(NullPointerException.class,()-> cmdParser.registerOption("-legacy",null)));

	}

	@Test
	public void boolValues() {
		String[] arguments = { "-legacy", "-no-borders", "filename1", "filename2" };
		var parser = new CmdLineParser();
		var options = new Application.PaintOptions();
		parser.registerOption("-legacy", () -> options.setLegacy(true));
		parser.registerOption("-with-borders", () -> options.setBordered(true));
		parser.registerOption("-no-borders", () -> options.setBordered(false));
		parser.process(arguments);

		assertAll(() -> assertEquals(true, options.isLegacy()), () -> assertEquals(false, options.isBordered()));
	}

	@Test
	public void option() {
		String[] arguments = { "-legacy", "-no-borders", "filename1", "filename2" };
		var parser = new CmdLineParser();
		var options = new Application.PaintOptions();
		parser.registerOption("-legacy", () -> options.setLegacy(true));
		parser.registerOption("-with-borders", () -> options.setBordered(true));
		parser.registerOption("-no-borders", () -> options.setBordered(false));
		parser.process(arguments);

		assertEquals("PaintOption [ bordered = false, legacy = true ]", options.toString());
	}

	@Test
	public void file() {
		String[] arguments = { "-legacy", "-no-borders", "filename1", "filename2" };
		var parser = new CmdLineParser();
		var options = new Application.PaintOptions();
		parser.registerOption("-legacy", () -> options.setLegacy(true));
		parser.registerOption("-with-borders", () -> options.setBordered(true));
		parser.registerOption("-no-borders", () -> options.setBordered(false));
		parser.process(arguments);
		var files = parser.getFiles().stream().map(Path::of).collect(Collectors.toList());

		assertEquals("[filename1, filename2]", files.toString());
	}

}