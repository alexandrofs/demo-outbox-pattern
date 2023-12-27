package com.example.demodynamostreams;

import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.types.InitializationInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ProcessRecordsInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ShutdownInput;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsAsyncClientBuilder;

@Service
public class DemoDynamoStreamsConsumer implements IRecordProcessor {

    @Override
    public void initialize(InitializationInput initializationInput) {

    }

    @Override
    public void processRecords(ProcessRecordsInput processRecordsInput) {

    }

    @Override
    public void shutdown(ShutdownInput shutdownInput) {

    }
}
