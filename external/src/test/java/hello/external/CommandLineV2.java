package hello.external;

import java.util.List;
import java.util.Set;

import org.springframework.boot.DefaultApplicationArguments;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV2 {
	public static void main(String[] args) {
		for (String arg : args) {
			log.info("arg {}", arg);
		}

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
		log.info("NonOptionsArgs = {}", appArgs.getNonOptionArgs());
		log.info("OptionsNames = {}", appArgs.getOptionNames());

		Set<String> optionNames = appArgs.getOptionNames();
		for (String optionName : optionNames) {
			log.info("option args {}={}", optionName, appArgs.getOptionValues(optionName));
		}

		List<String> url = appArgs.getOptionValues("url");
		List<String> username = appArgs.getOptionValues("username");
		List<String> password = appArgs.getOptionValues("password");
		List<String> mode = appArgs.getOptionValues("mode");
		log.info("url={}", url);
		log.info("username={}", username);
		log.info("password={}", password);
		log.info("mode={}", mode);
	}
}
