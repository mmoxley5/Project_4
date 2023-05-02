import java.util.Iterator;

public class Task implements Comparable<Task>,Iterable<Task>{
   @Override
   public int compareTo(Task o) {
      int compareResult = this.title.compareTo(o.title);
      if(compareResult == 0){
         if(this.getPriority()<o.getPriority()){
            return -1;
               
         }   
         }else{
            return compareResult;
         }
         return compareResult;
      }
   
   private String title;
   private String desc;
   private int priority;
  
   public Task(String title, String desc, int priority) {
      this.title = title;
      this.desc = desc;
      this.priority = priority;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getDesc() {
      return desc;
   }
   public void setDesc(String desc) {
      this.desc = desc;
   }
   public int getPriority() {
      return priority;
   }
   public void setPriority(int priority) {
      this.priority = priority;
   }
   @Override
   public String toString() {
      return "Task [title=" + title + ", desc=" + desc + ", priority=" + priority + "]";
   }
   @Override
   
   public Iterator<Task> iterator() {
         return this.iterator();
      }

}
