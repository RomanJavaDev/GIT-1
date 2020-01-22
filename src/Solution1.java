
/* "Разделение файла"
Нужно считать с консоли 3 имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
 - первую половину байт записать в файл2, вторую половину байт записать в файл3;
 - если в файл1 количество байт нечетное, то файл2 должен содержать большую часть;
 - закрыть потоки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        FileInputStream fis1 = new FileInputStream(s1);
        ArrayList<Integer> list = new ArrayList<>();

        while (fis1.available() > 0) {
            list.add(fis1.read());
        }
        fis1.close();
        FileOutputStream fos2 = new FileOutputStream(s2);
        FileOutputStream fos3 = new FileOutputStream(s3);

        if (list.size() % 2 == 0) {
            for (int i = 0; i < list.size() / 2; i++) {
                fos2.write(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++) {
                fos3.write(list.get(i));
            }
        }
        if (list.size() % 2 == 1) {
            for (int i = 0; i < (list.size() - (list.size() * 0.5)); i++) {
                fos2.write(list.get(i));
            }
            for (int i = (int) (list.size() - (list.size() * 0.5)) + 1; i < list.size(); i++) {
                fos3.write(list.get(i));
            }
        }
        fos2.close();
        fos3.close();
    }

}
