package nick.stuff.translation;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {

    @RequestMapping(value="/encode", method = RequestMethod.POST)
    public String encode(@RequestBody String data){
        int oneThird = data.length() / 3;
        int twoThirds = oneThird * 2;

        String first = data.substring(0, oneThird);
        String second = data.substring(oneThird, twoThirds);
        String third = data.substring(twoThirds);

        for (int i = 0; i < first.length(); i++){
            char c = first.charAt(i);
            c += 1000;
            first = first.replace(first.charAt(i), c);
        }

        for (int i = 0; i < second.length(); i++){
            char c = second.charAt(i);
            c -= 300;
            second = second.replace(second.charAt(i), c);
        }

        for (int i = 0; i < third.length(); i++){
            char c = third.charAt(i);
            c *= 42;
            third = third.replace(third.charAt(i), c);
        }


        return first + second + third;
    }

    @RequestMapping(value="/decode", method = RequestMethod.POST)
    public String decode(@RequestBody String data){
        int oneThird = data.length() / 3;
        int twoThirds = oneThird * 2;

        String first = data.substring(0, oneThird);
        String second = data.substring(oneThird, twoThirds);
        String third = data.substring(twoThirds);

        for (int i = 0; i < first.length(); i++){
            char c = first.charAt(i);
            c -= 1000;
            first = first.replace(first.charAt(i), c);
        }

        for (int i = 0; i < second.length(); i++){
            char c = second.charAt(i);
            c += 300;
            second = second.replace(second.charAt(i), c);
        }

        for (int i = 0; i < third.length(); i++){
            char c = third.charAt(i);
            c /= 42;
            third = third.replace(third.charAt(i), c);
        }

        return first + second + third;
    }
}
