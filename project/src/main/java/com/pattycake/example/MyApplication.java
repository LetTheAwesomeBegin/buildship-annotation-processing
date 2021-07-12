package com.pattycake.example;

import com.pattycake.example.api.NewBuilding;
import com.pattycake.example.api.OldBuilding;
import com.pattycake.example.core.BuildingMapper;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MyApplication implements CommandLineRunner {

  private BuildingMapper mapper;
  private NewBuilding pet;

  public MyApplication(BuildingMapper mapper) {
    this.mapper = Objects.requireNonNull(mapper);
  }

  public static void main(String... args) {
    SpringApplication.run(MyApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    OldBuilding source = OldBuilding.builder().name("Fancy").build();

    NewBuilding building = mapper.map(source);

    log.info("building[{}]", building);
  }
}
