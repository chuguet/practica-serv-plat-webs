package com.upsam.apuestas.batch.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.upsam.apuestas.batch.config.SpringBatchConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBatchConfiguration.class, loader = AnnotationConfigContextLoader.class)
public abstract class AbstractTest {

}
