class TrieNode{
	static int size = 26;
	static TrieNode root;
	TrieNode child[] ;
	boolean isEnd;
	TrieNode(){
		isEnd = false;
		for(int i=0; i<size; i++){
			child[i] = null;
		}
	}

	static boolean search(String key){
		TrieNode curr = root;
		for(int i=0; i<key.length(); i++){
			int index = key.charAt(i) - 'a';
			if(curr.child[index]==null)
				return false;
			curr = curr.child[index];
		}
		return curr.isEnd;
	}
	static void insert(String key){
		TrieNode curr = root;
		for(int i=0; i<key.length(); i++){
			int index = key.charAt(i) - 'a';
			if(curr.child[index]==null){
				curr.child[index] = new TrieNode();
			}
			curr = curr.child[index];
		}
		curr.isEnd = true;
	}
	public static void main(String[] args) {
		root = new TrieNode();
		String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
       
        String output[] = {"Not present in trie", "Present in trie"}; 
       
       
        root = new TrieNode(); 
       
        // Construct trie 
        int i; 
        for (i = 0; i < keys.length ; i++) 
            insert(keys[i]); 
       
        // Search for different keys 
        if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(search("these") == true) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(search("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
         
    
	}
}