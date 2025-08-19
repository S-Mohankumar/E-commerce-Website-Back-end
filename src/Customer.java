public class Customer extends User{
//   Customer customer = new Customer();
   public boolean verify(String UserPassword){
      if(this.GetAccountPassword().equals(UserPassword) ){
         return true;
      }
      else{
         return false;
      }

   }

}
