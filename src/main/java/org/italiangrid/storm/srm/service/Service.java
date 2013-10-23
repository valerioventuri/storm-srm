package org.italiangrid.storm.srm.service;

import gov.lbl.srm.StorageResourceManager.ArrayOfTExtraInfo;
import gov.lbl.srm.StorageResourceManager.ISRM;
import gov.lbl.srm.StorageResourceManager.SrmAbortFilesRequest;
import gov.lbl.srm.StorageResourceManager.SrmAbortFilesResponse;
import gov.lbl.srm.StorageResourceManager.SrmAbortRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmAbortRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmBringOnlineRequest;
import gov.lbl.srm.StorageResourceManager.SrmBringOnlineResponse;
import gov.lbl.srm.StorageResourceManager.SrmChangeSpaceForFilesRequest;
import gov.lbl.srm.StorageResourceManager.SrmChangeSpaceForFilesResponse;
import gov.lbl.srm.StorageResourceManager.SrmCheckPermissionRequest;
import gov.lbl.srm.StorageResourceManager.SrmCheckPermissionResponse;
import gov.lbl.srm.StorageResourceManager.SrmCopyRequest;
import gov.lbl.srm.StorageResourceManager.SrmCopyResponse;
import gov.lbl.srm.StorageResourceManager.SrmExtendFileLifeTimeInSpaceRequest;
import gov.lbl.srm.StorageResourceManager.SrmExtendFileLifeTimeInSpaceResponse;
import gov.lbl.srm.StorageResourceManager.SrmExtendFileLifeTimeRequest;
import gov.lbl.srm.StorageResourceManager.SrmExtendFileLifeTimeResponse;
import gov.lbl.srm.StorageResourceManager.SrmGetPermissionRequest;
import gov.lbl.srm.StorageResourceManager.SrmGetPermissionResponse;
import gov.lbl.srm.StorageResourceManager.SrmGetRequestSummaryRequest;
import gov.lbl.srm.StorageResourceManager.SrmGetRequestSummaryResponse;
import gov.lbl.srm.StorageResourceManager.SrmGetRequestTokensRequest;
import gov.lbl.srm.StorageResourceManager.SrmGetRequestTokensResponse;
import gov.lbl.srm.StorageResourceManager.SrmGetSpaceMetaDataRequest;
import gov.lbl.srm.StorageResourceManager.SrmGetSpaceMetaDataResponse;
import gov.lbl.srm.StorageResourceManager.SrmGetSpaceTokensRequest;
import gov.lbl.srm.StorageResourceManager.SrmGetSpaceTokensResponse;
import gov.lbl.srm.StorageResourceManager.SrmGetTransferProtocolsRequest;
import gov.lbl.srm.StorageResourceManager.SrmGetTransferProtocolsResponse;
import gov.lbl.srm.StorageResourceManager.SrmLsRequest;
import gov.lbl.srm.StorageResourceManager.SrmLsResponse;
import gov.lbl.srm.StorageResourceManager.SrmMkdirRequest;
import gov.lbl.srm.StorageResourceManager.SrmMkdirResponse;
import gov.lbl.srm.StorageResourceManager.SrmMvRequest;
import gov.lbl.srm.StorageResourceManager.SrmMvResponse;
import gov.lbl.srm.StorageResourceManager.SrmPingRequest;
import gov.lbl.srm.StorageResourceManager.SrmPingResponse;
import gov.lbl.srm.StorageResourceManager.SrmPrepareToGetRequest;
import gov.lbl.srm.StorageResourceManager.SrmPrepareToGetResponse;
import gov.lbl.srm.StorageResourceManager.SrmPrepareToPutRequest;
import gov.lbl.srm.StorageResourceManager.SrmPrepareToPutResponse;
import gov.lbl.srm.StorageResourceManager.SrmPurgeFromSpaceRequest;
import gov.lbl.srm.StorageResourceManager.SrmPurgeFromSpaceResponse;
import gov.lbl.srm.StorageResourceManager.SrmPutDoneRequest;
import gov.lbl.srm.StorageResourceManager.SrmPutDoneResponse;
import gov.lbl.srm.StorageResourceManager.SrmReleaseFilesRequest;
import gov.lbl.srm.StorageResourceManager.SrmReleaseFilesResponse;
import gov.lbl.srm.StorageResourceManager.SrmReleaseSpaceRequest;
import gov.lbl.srm.StorageResourceManager.SrmReleaseSpaceResponse;
import gov.lbl.srm.StorageResourceManager.SrmReserveSpaceRequest;
import gov.lbl.srm.StorageResourceManager.SrmReserveSpaceResponse;
import gov.lbl.srm.StorageResourceManager.SrmResumeRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmResumeRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmRmRequest;
import gov.lbl.srm.StorageResourceManager.SrmRmResponse;
import gov.lbl.srm.StorageResourceManager.SrmRmdirRequest;
import gov.lbl.srm.StorageResourceManager.SrmRmdirResponse;
import gov.lbl.srm.StorageResourceManager.SrmSetPermissionRequest;
import gov.lbl.srm.StorageResourceManager.SrmSetPermissionResponse;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfBringOnlineRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfBringOnlineRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfChangeSpaceForFilesRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfChangeSpaceForFilesRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfCopyRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfCopyRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfGetRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfGetRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfLsRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfLsRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfPutRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfPutRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfReserveSpaceRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfReserveSpaceRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfUpdateSpaceRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmStatusOfUpdateSpaceRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmSuspendRequestRequest;
import gov.lbl.srm.StorageResourceManager.SrmSuspendRequestResponse;
import gov.lbl.srm.StorageResourceManager.SrmUpdateSpaceRequest;
import gov.lbl.srm.StorageResourceManager.SrmUpdateSpaceResponse;
import gov.lbl.srm.StorageResourceManager.TExtraInfo;
import it.grid.storm.xmlrpc.ApiException;
import it.grid.storm.xmlrpc.BackendApi;
import it.grid.storm.xmlrpc.outputdata.PingOutputData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.italiangrid.utils.voms.VOMSSecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Service class used by Axis to serve srm calls.
 * 
 * Implements {@link ISRM} which is the service interface generated 
 * by Axis wsdl2java. This class is referenced in the wsdd file as the class implementing 
 * the service.
 * 
 * @author valerioventuri
 *
 */
public class Service implements ISRM {

	static final Logger logger = LoggerFactory.getLogger(Service.class);

	/**
	 * Interface to the backend service
	 * 
	 */
	private BackendApi core;

	/**
	 * Default ctor.
	 * 
	 */
	public Service() throws RuntimeException {

		try {
			
			core = new BackendApi();
		
		} catch (ApiException e) {

			logger.error("Cannot instantiate BackendApi class", e);
			
			throw new RuntimeException(e);
		}
	}
	
	public SrmPingResponse srmPing(SrmPingRequest srmPingRequest)
		throws RemoteException {

		logger.info("Serving ping call");
		
		/*
		 * get dn and voms info from the authn session
		 */

		VOMSSecurityContext securityContext = VOMSSecurityContext.getCurrentContext();
		
		List<String> fqans = securityContext.getVOMSAttributes().get(0).getFQANs();
		String dn = securityContext.getClientX500Name();
		
		/*
		 * call backend api
		 */
		
		PingOutputData pingOutputData = null;
		
		try {
		
			pingOutputData = core.ping(dn, fqans);
		
			// TODO this may throw a RunTimeException 
			// that would get to the client if not caught
			
		} catch (IllegalArgumentException e) {
		
			logger.error("Error calling remote ping", e);
			
			throw new RemoteException("Internal error");
		
		} catch (ApiException e) {
		
			logger.error("Error calling remote ping", e);
			
			throw new RemoteException("Internal error");
		}
		
		/*
		 * prepare and return response
		 * 
		 */
		
		SrmPingResponse response = new SrmPingResponse();

		response.setVersionInfo(pingOutputData.getBeVersion());

		List<TExtraInfo> otherInfoList = new ArrayList<TExtraInfo>();

		TExtraInfo typeExtraInfo = new TExtraInfo();
		typeExtraInfo.setKey("backend_type");
		typeExtraInfo.setValue("StoRM");

		otherInfoList.add(typeExtraInfo);

		ArrayOfTExtraInfo otherInfo = new ArrayOfTExtraInfo(
			otherInfoList.toArray(new TExtraInfo[] {}));

		response.setOtherInfo(otherInfo);

		return response;

	}

	public SrmReserveSpaceResponse srmReserveSpace(
		SrmReserveSpaceRequest srmReserveSpaceRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmStatusOfReserveSpaceRequestResponse srmStatusOfReserveSpaceRequest(
		SrmStatusOfReserveSpaceRequestRequest srmStatusOfReserveSpaceRequestRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmReleaseSpaceResponse srmReleaseSpace(
		SrmReleaseSpaceRequest srmReleaseSpaceRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmUpdateSpaceResponse srmUpdateSpace(
		SrmUpdateSpaceRequest srmUpdateSpaceRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmStatusOfUpdateSpaceRequestResponse srmStatusOfUpdateSpaceRequest(
		SrmStatusOfUpdateSpaceRequestRequest srmStatusOfUpdateSpaceRequestRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmGetSpaceMetaDataResponse srmGetSpaceMetaData(
		SrmGetSpaceMetaDataRequest srmGetSpaceMetaDataRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmChangeSpaceForFilesResponse srmChangeSpaceForFiles(
		SrmChangeSpaceForFilesRequest srmChangeSpaceForFilesRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmStatusOfChangeSpaceForFilesRequestResponse srmStatusOfChangeSpaceForFilesRequest(
		SrmStatusOfChangeSpaceForFilesRequestRequest srmStatusOfChangeSpaceForFilesRequestRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmExtendFileLifeTimeInSpaceResponse srmExtendFileLifeTimeInSpace(
		SrmExtendFileLifeTimeInSpaceRequest srmExtendFileLifeTimeInSpaceRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmPurgeFromSpaceResponse srmPurgeFromSpace(
		SrmPurgeFromSpaceRequest srmPurgeFromSpaceRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmGetSpaceTokensResponse srmGetSpaceTokens(
		SrmGetSpaceTokensRequest srmGetSpaceTokensRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmSetPermissionResponse srmSetPermission(
		SrmSetPermissionRequest srmSetPermissionRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmCheckPermissionResponse srmCheckPermission(
		SrmCheckPermissionRequest srmCheckPermissionRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmGetPermissionResponse srmGetPermission(
		SrmGetPermissionRequest srmGetPermissionRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmMkdirResponse srmMkdir(SrmMkdirRequest srmMkdirRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmRmdirResponse srmRmdir(SrmRmdirRequest srmRmdirRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmRmResponse srmRm(SrmRmRequest srmRmRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmLsResponse srmLs(SrmLsRequest srmLsRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmStatusOfLsRequestResponse srmStatusOfLsRequest(
		SrmStatusOfLsRequestRequest srmStatusOfLsRequestRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmMvResponse srmMv(SrmMvRequest srmMvRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmPrepareToGetResponse srmPrepareToGet(
		SrmPrepareToGetRequest srmPrepareToGetRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmStatusOfGetRequestResponse srmStatusOfGetRequest(
		SrmStatusOfGetRequestRequest srmStatusOfGetRequestRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmBringOnlineResponse srmBringOnline(
		SrmBringOnlineRequest srmBringOnlineRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmStatusOfBringOnlineRequestResponse srmStatusOfBringOnlineRequest(
		SrmStatusOfBringOnlineRequestRequest srmStatusOfBringOnlineRequestRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmPrepareToPutResponse srmPrepareToPut(
		SrmPrepareToPutRequest srmPrepareToPutRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmStatusOfPutRequestResponse srmStatusOfPutRequest(
		SrmStatusOfPutRequestRequest srmStatusOfPutRequestRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmCopyResponse srmCopy(SrmCopyRequest srmCopyRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmStatusOfCopyRequestResponse srmStatusOfCopyRequest(
		SrmStatusOfCopyRequestRequest srmStatusOfCopyRequestRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmReleaseFilesResponse srmReleaseFiles(
		SrmReleaseFilesRequest srmReleaseFilesRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmPutDoneResponse srmPutDone(SrmPutDoneRequest srmPutDoneRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmAbortRequestResponse srmAbortRequest(
		SrmAbortRequestRequest srmAbortRequestRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmAbortFilesResponse srmAbortFiles(
		SrmAbortFilesRequest srmAbortFilesRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmSuspendRequestResponse srmSuspendRequest(
		SrmSuspendRequestRequest srmSuspendRequestRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmResumeRequestResponse srmResumeRequest(
		SrmResumeRequestRequest srmResumeRequestRequest) throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmGetRequestSummaryResponse srmGetRequestSummary(
		SrmGetRequestSummaryRequest srmGetRequestSummaryRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmExtendFileLifeTimeResponse srmExtendFileLifeTime(
		SrmExtendFileLifeTimeRequest srmExtendFileLifeTimeRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmGetRequestTokensResponse srmGetRequestTokens(
		SrmGetRequestTokensRequest srmGetRequestTokensRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}

	public SrmGetTransferProtocolsResponse srmGetTransferProtocols(
		SrmGetTransferProtocolsRequest srmGetTransferProtocolsRequest)
		throws RemoteException {

		// TODO Auto-generated method stub
		return null;
	}
	
}
