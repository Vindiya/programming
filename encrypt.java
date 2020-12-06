import java.util.*;
class tempCodeRunnerFile {
    
    public static void main(String[] args) {
        String key="I cant even wanna talk about xyz or whatever the f happened last night with jomqer.";
        // I,C,A,N,T,E,V,W,L,K,B,O,U,X,Y,Z,R,H,F,P,D,S,G,J,M,Q
        // A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z
        String message="I ain't in the mood to talk to you!";
        String expected="L ilx'p lx pwt uyyn py piob py myd!";
        String message2="Go to hell Samarth K.";
        String expected2="Vy py wtoo Fiuihpw B.";
        String output1 = encrypt(key, message);
        String output2 = encrypt(key, message2);
        System.out.println(output1.equals(expected));
        System.out.println(output2.equals(expected2));
    }
    public static String encrypt(String key, String message) {
        int[] arr = new int[26];
        int index=0;
        HashSet<Character> visited = new HashSet<>();
        for(char c: key.toCharArray()) {
            c = Character.toLowerCase(c);
            if(!Character.isLetter(c) || visited.contains(c)) {
                continue;
            }
            arr[index++] = c-'a';
            visited.add(c);
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(char c: message.toCharArray()) {
            if(Character.isLetter(c)) {
                flag = Character.isUpperCase(c);
                if(flag) c = Character.toLowerCase(c);
                index = arr[c-'a'];
                char newChar = (char)('a'+index);
                if(flag) sb.append(Character.toUpperCase(newChar));
                else sb.append(newChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}