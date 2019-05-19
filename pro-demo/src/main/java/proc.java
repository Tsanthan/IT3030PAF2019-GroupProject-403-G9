import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class proc {

@RequestMapping("/hello")
	public String test() {
	
	return "hello world";
	
}
	
	
}
