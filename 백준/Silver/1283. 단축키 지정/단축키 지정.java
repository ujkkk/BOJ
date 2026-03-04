import javax.print.attribute.standard.PresentationDirection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 단축키 중복을 관리하는 저장소
class ShortcutRegistry {
    private final boolean[] used = new boolean[26];

    public boolean isAvailable(char c){
        int idx = Character.toLowerCase(c) - 'a';
        return !used[idx];
    }

    public void register(char c){
        int index = Character.toLowerCase(c) - 'a';
        used[index] = true;
    }
}

// 2. 하나의 메뉴 옵션
class MenuOption {
    private final String rawText;
    private int shrtcutIndex = -1;

    public MenuOption(String rawText){
        this.rawText = rawText;
    }

    public void assignShortcut(ShortcutRegistry registry){
        if (tryAssignFirstLetters(registry)) return;
        tryAssignAnyLetters(registry);
    }

    private boolean tryAssignFirstLetters(ShortcutRegistry registry){
        String[] words = rawText.split(" ");
        int curIdx = 0;

        for(String word : words){
            char firstChar = word.charAt(0);
            if(registry.isAvailable(firstChar)){
                registry.register(firstChar);
                this.shrtcutIndex = curIdx;
                return true;
            }
            curIdx += word.length() + 1;
        }
        return false;
    }

    private void tryAssignAnyLetters(ShortcutRegistry registry){
        for(int i=0; i<rawText.length(); i++){
            char c = rawText.charAt(i);
            if(c == ' '){
                continue;
            }
            if(registry.isAvailable(c)){
                registry.register(c);
                this.shrtcutIndex = i;
                return;
            }
        }
    }

    @Override
    public String toString(){
        if(shrtcutIndex == -1) return rawText;

        StringBuilder sb = new StringBuilder(rawText);
        sb.insert(shrtcutIndex+1,"]");
        sb.insert(shrtcutIndex, "[");
        return sb.toString();
    }
}

public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ShortcutRegistry registry = new ShortcutRegistry();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<n; i++){
            MenuOption option = new MenuOption(br.readLine());
            option.assignShortcut(registry);
            result.append(option).append("\n");
        }

        System.out.println(result);
    }
}
