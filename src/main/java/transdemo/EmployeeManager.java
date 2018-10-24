package transdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
public class EmployeeManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void changeSalaries(int first, int second) {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("New Trasaction ...  " + status.isNewTransaction());
		//try {
			int count = jdbcTemplate.update("update employees  set salary = 10000 where employee_id = " + first);
			if (count == 0)
				throw new UpdateException("Update of " + first + " failed!");
			else
				System.out.println("Updated salary of " + first);

			count = jdbcTemplate.update("update employees  set salary = 10000 where employee_id = " + second);
			if (count == 0)
				throw new UpdateException("Update of " + second + " failed!");

			System.out.println("Commiting transaction ...");
//		} catch (Exception ex) {
//			System.out.println("Error : " + ex.getMessage());
//			System.out.println("Rolling back transaction ....");
//			status.setRollbackOnly();
//		}

	}

}
