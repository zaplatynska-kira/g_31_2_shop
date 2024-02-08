package de.aittr.g_31_2_shop.scheduling;

import de.aittr.g_31_2_shop.domain.jpa.Task;
import de.aittr.g_31_2_shop.services.jpa.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@EnableScheduling
@EnableAsync
public class ScheduleExecutor {
   // private TaskService taskService;

   // private static Logger logger= LoggerFactory.getLogger(ScheduleExecutor.class);

    //public ScheduleExecutor(TaskService taskService) {
        //this.taskService = taskService;
    //}


    //@Scheduled(fixedDelay = 5000)
    //public  void  fixedDelayTask () {
    //taskService.createTask("Fixed delay task");
    //}
    //@Scheduled(fixedDelay = 5000)
    //public  void  fixedDelayTask () {
    // taskService.createTask("Fixed delay task 3000 ms");
    //try{
    //Thread.sleep(3000);

    //}catch (InterruptedException e){
    //throw new RuntimeException(e);
    //}


    // @Scheduled(fixedDelay = 5000)
    //public void fixedDelayTask() {
    // taskService.createTask("Fixed delay task 7000 ms");
    // try {
    //Thread.sleep(7000);

    // } catch (InterruptedException e) {
    //throw new RuntimeException(e);
    // }




    /*@Scheduled(fixedRate = 5000)
    public void fixedRateTask() {
        taskService.createTask("Fixed rate task 3000 ms");
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }*/


    // @Scheduled(fixedRate = 5000)
    //public void fixedRateTask() {
    //taskService.createTask("Fixed rate task 7000 ms");
    //try {
    //Thread.sleep(7000);

    // } catch (InterruptedException e) {
    // throw new RuntimeException(e);
    // }


    // @Scheduled(fixedRate = 5000)
    //@Async
    //public void fixedRateAsyncTask() {
    //taskService.createTask("Fixed rate async task 7000 ms");
    //try {
    //Thread.sleep(7000);

    //} catch (InterruptedException e) {
    // throw new RuntimeException(e);
    //}


    //@Scheduled(fixedDelay = 5000, initialDelay = 20000)

    //public void initialDelayTask() {
    //taskService.createTask("InitialDelayTask");

    //}
    //2 часа 7200 000 millisec->   PT2H -период времени 2 часа, "PT3S" 3 секунды


    //  55 * * * * * ->  каждую минуту в момент времени 55 секунд
    // 0 10,20 * * * * -> каждый час в 10 минут и 20 минут
    // 0 15 9-17 * * MON-FRI -> по будням с 9 до 17 часов в 15 минут каждого часа


    //@Scheduled(fixedDelayString = "PT3S")

    //public void anotherDelayFormatTask() {
    //taskService.createTask("AnotherDelayFormatTask");


    //@Scheduled(cron = "10,30 * * * * *" )

    //public void cronExpressionTask() {
    //taskService.createTask("cronExpressionTask");

    //}

//public  static void scheduleAndExecuteTask(Task task){
    //TaskScheduler scheduler= new DefaultManagedTaskScheduler();

    //scheduler.schedule(

            //() ->logger.info(task.getDescription()),
            //new CronTrigger("0,10,20,30,40,50 * * * * *")
    //);




    //public  static void scheduleAndExecuteTask(Task task){
        //TaskScheduler scheduler= new DefaultManagedTaskScheduler();
       // Instant instant = Instant.now().plusSeconds(30);
       // scheduler.schedule(

               // () ->logger.info(task.getDescription()),
              // instant
       // );

    }







