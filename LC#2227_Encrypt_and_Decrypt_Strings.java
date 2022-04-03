class Encrypter {

    private static String[] key_to_value;
    private static String[] dictionary;
    public Encrypter(char[] keys, String[] values, String[] _dictionary) {
        
        key_to_value = new String[26];
        dictionary = _dictionary;
        for (int i = 0; i < keys.length; i++) {
            key_to_value[keys[i] - 'a'] = values[i];
        }
    }
    
    public String encrypt(String word1) {
        
        StringBuilder result = new StringBuilder();
        for (char c : word1.toCharArray()) result.append(key_to_value[c - 'a']);
        return result.toString();
    }
    
    public int decrypt(String word2) {
        
        int ans = 0;
        for (String str : dictionary) {
            StringBuilder result = new StringBuilder();
            for (char c : str.toCharArray()) {
                result.append(key_to_value[c - 'a']);
            }
            if (word2.equals(result.toString())) ans++;
        }
        
        return ans;
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */