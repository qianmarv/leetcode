import java.util.*;

class FreedomTrial {
    // public int findRotateSteps(String ring, String key){
    //     int len = ring.length();
    //     int[] path = new int[key.length()];
    //     for(int i = 0; i < key.length(); i++){
    //         path[i] = Integer.MAX_VALUE;
    //     }
    //     Queue<Integer> indices = new LinkedList<>();
    //     indices.put(0);
    //     for(int i = 0; i < key.length(); i++){
    //         char c = key.charAt(i);
    //         while(!indices.isEmpty()){
    //             int size = indices.size();
    //             while(size-- > 0){
    //                 int currIndex = indices.poll();
    //                 if(ring.charAt(currIndex) == c){
    //                     path[currIndex] = Math.min(path[currIndex], );
    //                 }
    //             }
    //         }
    //     }
    // }
    public int findRotateSteps2(String ring, String keyStr) {
        int len = ring.length();
        Map<Integer, Integer> curr = new HashMap<>();
        Map<Integer, Integer> next = new HashMap<>();
        next.put(0,0);
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < keyStr.length(); i++){
            curr.clear();
            curr = next;
            next = new HashMap<>();
            char c = keyStr.charAt(i);

            for(int key: curr.keySet()){
                int prePath = curr.get(key);
                int curPath = 0;
                 // System.out.printf("Index %d, try %c\n", key, c);
                //curr.remove(key);
                //current position
                if(ring.charAt(key) == c){
                    curPath = prePath + 1;
                    next.put(key, curPath);
                    // System.out.printf("In current position.\n");
                    if(i == keyStr.length() - 1){ // last round
                        ret = Math.min(ret, curPath);
                    }
                }else{
                    //lockwise
                    int indexR = ring.indexOf(c, key);
                    int curPathR = 0;
                    indexR = indexR != -1 ? indexR : ring.indexOf(c);
                    if(indexR > key){
                        curPathR = prePath + indexR - key + 1;
                    }else{
                        curPathR = prePath + len - key + indexR + 1;
                    }
                    if(!(next.containsKey(indexR) && next.get(indexR) < curPathR)){
                        next.put(indexR, curPathR);
                    }
                    // if(i == keyStr.length() - 1){ // last round
                    //     ret = Math.min(ret, curPathR);
                    // }
                    // System.out.printf("Right Index:%d-Path:%d~~", indexR, curPathR);
                    //anticlockwise
                    int indexL = ring.lastIndexOf(c, key);
                    int curPathL = 0;
                    indexL = indexL != -1 ? indexL : ring.lastIndexOf(c);

                    if(indexL < key){
                        curPathL = prePath + key - indexL + 1;
                    }else{
                        curPathL = prePath + len - indexL + key + 1;
                    }

                    if(!(next.containsKey(indexL) && next.get(indexL) < curPathL)){
                        next.put(indexL, curPathL);
                    }
                    
                    if(i == keyStr.length() - 1){ // last round
                        ret = Math.min(ret, Math.min(curPathL, curPathR));
                    }
                    // System.out.printf("Left Index %d-Path:%d\n", indexL, curPathL);
                }
            }
        }

        return ret;
    }
    public static void main(String[] args) {
        FreedomTrial so = new FreedomTrial();
        String ring   = args[0];
        String keyStr = args[1];
        System.out.println(so.findRotateSteps(ring, keyStr));
    }
}
