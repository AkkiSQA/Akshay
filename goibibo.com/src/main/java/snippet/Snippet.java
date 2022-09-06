package snippet;

public class Snippet {
	public static void main(String[] args) {
		<dependencies>
				<dependency>
					<groupId>org.seleniumhq.selenium</groupId>
					<artifactId>selenium-java</artifactId>
					<version>4.1.0</version>
				</dependency>
				<dependency>
					<groupId>io.github.bonigarcia</groupId>
					<artifactId>webdrivermanager</artifactId>
					<version>4.1.0</version>
				</dependency>
				<dependency>
					<groupId>org.testng</groupId>
					<artifactId>testng</artifactId>
					<version>7.4.0</version>
					<scope>test</scope>
				</dependency>
				<!-- https://mvnrepository.com/artifact/com.relevantcodes/extentreports -->
		<dependency>
		    <groupId>com.relevantcodes</groupId>
		    <artifactId>extentreports</artifactId>
		    <version>2.41.2</version>
		</dependency>
				
				<dependency>
					<groupId>org.apache.poi</groupId>
					<artifactId>poi-ooxml-schemas</artifactId>
					<version>4.1.2</version>
				</dependency>
			</dependencies>
			<build>
				<plugins>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-compiler-plugin</artifactId>
						<version>3.10.1</version>
						<configuration>
							<source>1.8</source>
							<target>1.8</target>
						</configuration>
					</plugin>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-surefire-plugin</artifactId>
						<version>3.0.0-M5</version>
						<configuration>
							<suiteXmlFiles>
								<suiteXmlFile>testng.xml</suiteXmlFile>
							</suiteXmlFiles>
						</configuration>
					</plugin>
				</plugins>
			</build>
	}
}

