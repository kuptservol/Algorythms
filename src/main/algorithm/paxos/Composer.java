package algorithm.paxos;

import algorithm.paxos.message.PromiseEvent;

/**
 * Created by Сергей on 01.03.2016.
 */
public interface Composer {

    void prepare(String value);

    void receivePromise(PromiseEvent promiseEvent);

}
