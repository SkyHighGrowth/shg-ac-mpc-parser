package com.shg.bmapi.utils;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.stream.IntStream;

public class ArgumentVerifier {

    private ArgumentVerifier() {

    }

    /**
     * Check if any of the arguments have null value
     *
     * @param objects Objects to be verified
     * */
    public static void verifyNotNull(final Object... objects) {

        IntStream.range(0, objects.length).forEach(i -> {

            Object obj = objects[i];

            if (obj == null) {

                try {
                    throw new Exception(
                            String.format(
                                    "Provided argument on position [%d] is null.",
                                    i
                            )
                    );
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(),e);
                }
            }
        });
    }

    /**
     * Method that checks if provided collection is empty or null
     *
     * @param collections Collections to be checked
     */
    public static void verifyNotEmpty(Collection<?>... collections) {

        IntStream.range(0, collections.length).forEach(i -> {
            Collection<?> collection = collections[i];

            if (CollectionUtils.isEmpty(collection)) {
                try {
                    throw new Exception(
                            String.format(
                                    "Provided collection [%d] is empty or null.",
                                    i
                            )
                    );
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(),e);
                }
            }
        });

    }
}
