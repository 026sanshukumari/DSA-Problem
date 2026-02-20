class Solution {
    public void processLineWithKWords(
            List<String> currLine, int currWidth, int maxWidth, List<String> result) {
                
        int totalSpaces = maxWidth - currWidth + (currLine.size() - 1);
        int gaps = currLine.size() - 1;

        int evenSpaces = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < currLine.size(); i++) {
            sb.append(currLine.get(i));

            if (i < gaps) {
                int spaces = evenSpaces + (i < extraSpaces ? 1 : 0);
                for (int s = 0; s < spaces; s++) sb.append(" ");
            }
        }
        result.add(sb.toString());
    }

    public void processLineWithOneWord(
            List<String> currLine, int currWidth, int maxWidth, List<String> result) {

        StringBuilder sb = new StringBuilder(currLine.get(0));
        while (sb.length() < maxWidth) sb.append(" ");
        result.add(sb.toString());
    }

    public void processLastLine(
            List<String> currLine, int currWidth, int maxWidth, List<String> result) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < currLine.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(currLine.get(i));
        }

        while (sb.length() < maxWidth) sb.append(" ");
        result.add(sb.toString());
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currLine = new ArrayList<>();
        int currWidth = 0;

        for (String word : words) {
            int newWidth = currLine.isEmpty()
                    ? word.length()
                    : currWidth + word.length() + 1;

            if (newWidth <= maxWidth) {
                currLine.add(word);
                currWidth = newWidth;
            } else {
                if (currLine.size() > 1) {
                    processLineWithKWords(currLine, currWidth, maxWidth, result);
                } else {
                    processLineWithOneWord(currLine, currWidth, maxWidth, result);
                }
                currLine = new ArrayList<>();
                currLine.add(word);
                currWidth = word.length();
            }
        }

        processLastLine(currLine, currWidth, maxWidth, result);
        return result;
    }
}