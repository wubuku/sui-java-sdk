package com.github.wubuku.sui;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

public class CustomInterceptor implements Interceptor {
    /*
    private final String targetUrl;
    private final AtomicInteger requestCount = new AtomicInteger(0);

    public CustomInterceptor(String targetUrl) {
        this.targetUrl = targetUrl;
        startRequestCountPrinter();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (request.url().toString().contains(targetUrl)) {

            System.out.println("Request URL: " + request.url());
            System.out.println("Request Headers: " + request.headers());

            requestCount.incrementAndGet();
        }
        return chain.proceed(request);
    }

    private void startRequestCountPrinter() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            int count = requestCount.getAndSet(0);
            System.out.println("Requests in the last second: " + count);
        }, 1, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        String targetUrl = "https://github.com";
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new CustomInterceptor(targetUrl))
                .build();
        while (true) {
            Request request = new Request.Builder()
                    .url(targetUrl)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                System.out.println("Response: " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sleep(250);
        }
    }
     */

    private final AtomicInteger count = new AtomicInteger(0);
    private final AtomicLong lastTime = new AtomicLong(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        String targetUrl = "https://github.com";
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new CustomInterceptor())
                .build();
        while (true) {
            Request request = new Request.Builder()
                    .url(targetUrl)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                System.out.println("Response: " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sleep(100);
        }
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // System.out.println("Request URL: " + request.url());
        // System.out.println("Request Headers: " + request.headers());

        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastTime.get();

        if (elapsedTime >= 1000) {
            int currentCount = count.getAndSet(0);
            System.out.println("Recent One Second Counter: " + currentCount / (elapsedTime / 1000));
            lastTime.set(currentTime);
        }

        count.incrementAndGet();
        return chain.proceed(request);
    }
}