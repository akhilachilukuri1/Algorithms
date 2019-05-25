class StringIterator {
static String word;
    static int counter=0;
    public StringIterator(String compressedString) {
        StringBuilder sb=new StringBuilder();
            char prev=compressedString.charAt(0);
      for(int i=0;i<=compressedString.length()-1;i++)
      {
          char ch=compressedString.charAt(i);
          if(ch>='1'&&ch<='9')
          {
              int num=Character.getNumericValue(ch);
              while(num!=0)
              {
                  sb.append(prev);
                  num--;
              }
          } 
          else
          {
              prev=ch;
          }
      }
 
        word=sb.toString();
        System.out.println(word);
    }
    
    public char next() {
        if(counter<word.length())
        {
        return word.charAt(counter++);
        }
        else
        {
            return ' ';
        }
    }
    
    public boolean hasNext() {
        if(counter+1<=word.length()-1)
        {
            return true;
        }else
        {
            return false;
        }
    }


    
    public static void main(String[] args)
    {
    	StringIterator iterator =new StringIterator("L10e2t1C1o1d1e11");
    	System.out.println(iterator.next()); // return 'L'
    	System.out.println(iterator.next()); // return 'e'
    	System.out.println(iterator.next()); // return 'e'
    	System.out.println(iterator.next()); // return 't'
    	System.out.println(iterator.next()); // return 'C'
    	System.out.println(iterator.next()); // return 'o'
    	//System.out.println(iterator.next()); // return 'd'
    	System.out.println(iterator.hasNext()); // return true
    	System.out.println(iterator.next()); // return 'e'
    	System.out.println(iterator.hasNext()); // return false
    	//System.out.println(iterator.next()); // return ' '
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */