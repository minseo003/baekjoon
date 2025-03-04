import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        FileName[] fileArray = new FileName[files.length];

        for (int i = 0; i < files.length; i++) {
            fileArray[i] = new FileName(files[i],i);
        }

        Arrays.sort(fileArray);

        String[] answer = new String[files.length];
        for(int i = 0 ; i < files.length ; i++) {
            answer[i] = fileArray[i].original;
        }
        return answer;
    }
}

class FileName implements Comparable<FileName> {

    String original;
    String head;
    int number;
    int index;  // 기존 순서 유지용

    public FileName(String file, int index) {
        this.original = file;
        this.index = index;

        String[] parts = splitFile(file);
        this.head = parts[0];
        this.number = Integer.parseInt(parts[1]);
    }

    private String[] splitFile(String file) {
        String head = "";
        String number = "";
        int i = 0;

        while(i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }

        while(i < file.length() && Character.isDigit(file.charAt(i))) {
            number += file.charAt(i);
            i++;
        }

        return new String[]{head,number};
    }

    @Override
    public int compareTo(FileName o) {
        int headCompare = this.head.compareToIgnoreCase(o.head);
        if(headCompare != 0) return headCompare;

        int numberCompare = Integer.compare(this.number, o.number);
        if(numberCompare != 0) return numberCompare;

        return Integer.compare(this.index, o.index);
    }
}