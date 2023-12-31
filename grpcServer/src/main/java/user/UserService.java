package user;

import com.company.grpc.User.APIResponse;
import com.company.grpc.User.Empty;
import com.company.grpc.User.LoginRequest;
import com.company.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		
		System.out.println("Inside login");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			
			 // return success message
			
			response.setResponseCode(200).setResponsemessage("SUCCESS");
			
		}
		else {
			response.setResponseCode(400).setResponsemessage("INVALID PASSWORD");
		}
		
		
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
	}

	
	 
}
