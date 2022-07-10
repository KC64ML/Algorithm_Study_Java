package SWExpertAcademy;

import java.io.*;

public class sw1959 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0 ;i<t;i++){
            String[] str = br.readLine().split(" ");
            int[] arr =  new int[str.length];
            for(int j =0; j< arr.length;j++){
                arr[j] = Integer.parseInt(str[j]);
            }

            int[] arrn = new int[arr[0]];
            int[] arrm = new int[arr[1]];

            String[] str2 = br.readLine().split(" ");
            String[] str3 = br.readLine().split(" ");

            for(int j =0; j< arr[0];j++){
                arrn[j] = Integer.parseInt(str2[j]);
            }
            for(int j =0; j< arr[1];j++){
                arrm[j] = Integer.parseInt(str3[j]);
            }

            int[] maxarr;
            int[] minarr;

            if(arrn.length > arrm.length){
                maxarr = arrn;
                minarr = arrm;
            }else{
                maxarr = arrm;
                minarr = arrn;
            }

            long result = 0;
            for(int k = 0 ;k <= maxarr.length - minarr.length;k++){
                long curResult = 0;
                for(int k2 = k; k2 < k+ minarr.length;k2++){
                    curResult += (minarr[k2-k] * maxarr[k2]);
                }

                if(result < curResult){
                    result = curResult;
                }
            }

            bw.write("#"+(i+1)+" "+result);
            bw.newLine();

        }

        bw.flush();
        br.close();
        bw.close();
    }
}
