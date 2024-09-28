package com.xiaohub.analysed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
public class XiaohubAnalysedApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(XiaohubAnalysedApplication.class, args);

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			try {
				Thread.sleep(5000); // 给应用 5 秒钟来尝试优雅关闭
				System.out.println("Application is shutting down forcefully...");
				System.exit(0);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}));
	}

}
