package ch17.akka;

import ch17.TempInfo;
import ch17.TempProcessor;
import ch17.TempSubscriber;
import ch17.TempSubscription;

import javax.xml.transform.Source;
import java.util.concurrent.Flow;

public class MainCelsius {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("temp-info");
        Materializer materializer = ActorMaterializer.create(system);

        Flow.Publisher<TempInfo> publisher =
                Source.fromPublisher(getCelsiusTemperatures("New York"))
                        .runWith(Sink.asPublisher(AsPublisher.WITH_FANOUT), materializer);
        publisher.subscribe(new TempSubscriber());

        try {
            Thread.sleep(10000L);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }
}
