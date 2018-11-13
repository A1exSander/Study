package lesson10.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;

public class Objects {
    public static void main(String[] args) throws InterruptedException {
//        byte[][] store = new byte[1024][]; - сильная ссылка, может забить память, но хрен удалишь
//
//        for (int i = 0; ; i++){
//            if(i<0) {
//                i=0;
//
//                byte[] bytes = new byte[1024*1024];
//                store[i % store.length] = byte;
//
//                Thread.sleep(10);
//            }
//        }

        Object[] objects = new Object[1024 * 1024];
        for (int i = 0; ; i++) {
            if (i < 0) {
                i = 0;

                byte[] bytes = new byte[1024 * 1024];
                objects[i % objects.length] = new SoftReference<>(bytes); // - мягкая ссылка. При сборке мусора, если на них не осталось сильных ссылок, они будут удалены
                //WeakReference<>(bytes); - слабая ссылка. Будут удаляться только если памяти не хватает (используется при кэшировании) Так же не будет удаляться, пока остаются сильные ссылки
                //PhantomReference(bytes); - не дает доступа к объекту. Помечает объект для удаления.
                Thread.sleep(10);
            }
        }
    }
}
