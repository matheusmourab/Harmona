import boto3

s3_client = boto3.client(
    "s3",
    endpoint_url=f"http://localhost:4566",
    aws_access_key_id="admin",
    aws_secret_access_key="admin"
)

s3_client.create_bucket(Bucket="harmona-bucket")