import com.company.grpc.User.APIResponse;
import com.company.grpc.User.LoginRequest;
import com.company.grpc.userGrpc;
import com.company.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8080).usePlaintext().build();
		
		// stubs - generate from proto
		
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("shashank").setPassword("shashank").build();
		
		APIResponse response = userStub.login(loginrequest);
		
		System.out.println(response.getResponsemessage());
		
		
	}

}
